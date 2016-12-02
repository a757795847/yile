package com.jfinal.weixin.controller.login;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.StrKit;
import com.jfinal.others.MyCaptchaRender;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import java.util.List;

import static com.jfinal.others.Constant.*;
import static jxl.biff.FormatRecord.logger;

/**
 * Created by zengriyong on 16/11/11.
 */
public class LoginController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    //    @Before(UserAuthInterceptor.class)
    public void index() {
        render("/views/pepsi/login.jsp");
    }

    @ActionKey("/yile/login/post")
//    @Before(UserAuthInterceptor.class)
    public void determine() throws Exception {
        String userName = getPara("username");
        String password = getPara("password");
        String inputRandomCode = getPara("captcha");
        boolean validate = MyCaptchaRender.validate(this, inputRandomCode);

        logger.debug("userName: " + userName + " , password: " + password + ", captcha: " + inputRandomCode);
        logger.debug("CaptchaRender.validate=" + validate + ";inputRandomCode=" + inputRandomCode);

        /**
         * 1、验证码错误
         * 2、用户名或密码错误
         * 3、该用户已被停用！
         * 4、该用户连续输错4次密码，已被锁定！你可以到VM后台电脑端‘登录页面’【取回密码】来解锁和获取新的密码！
         *
         */

        if (StrKit.notBlank(userName, password, inputRandomCode)) {
            String sql1 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and `status` != '1' and pwderrorcount < '4'";
            Vmmisuser users1 = Vmmisuser.dao.findFirst(sql1, userName, password);
            if (StrKit.isBlank(users1.getLoginname())) {
                renderJson("user_error", USER_ERROR);
            } else if (validate == false) {
                renderJson("msg_error", MSG_ERROR);
            } else {
                String sql2 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and pwderrorcount >= '4'";
                List<Vmmisuser> users2 = Vmmisuser.dao.find(sql2, userName, password);
                String sql3 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and `status` = '1'";
                List<Vmmisuser> users3 = Vmmisuser.dao.find(sql3, userName, password);

                if (users2.size() > 0) {
                    renderJson("psd_beyond", PSD_BEYONG);
                } else if (users3.size() > 0) {
                    renderJson("user_disable", USER_DISABLE);
                } else {

                    //正常登录
                    String RememberPwd = getPara("RememberPwd");
                    if (StrKit.notBlank(RememberPwd)) {
                        String pwd = new StringBuilder(password).reverse().toString();
                        //记住密码
                        setCookie("username", userName, 1209600);
                        setCookie("password", pwd, 1209600);
                    }
                    String AutomaticLogin = getPara("AutomaticLogin");
                    System.out.println("AutomaticLogin: " + AutomaticLogin);
                    if (StrKit.notBlank(AutomaticLogin)) {
                        //自动登录(1、session取openId; 2、调用接口存openId)
                        String openId = getSessionAttr("openId");
                        //2、调用接口存openId
                        int i = 0;
                        do {
                            String url = "http://115.29.179.158/vmmis/updateFanopenid?loginname=" + userName + "&fanopenid=" + openId + "&vmcustomerid=" + users1.getVmcustomerid();
                            System.out.println("url: " + url);
                            String str = HttpKit.get(url);
                            System.out.println("str: " + str);
                            i++;
                        } while (i < 3);
                    }

                    setSessionAttr("userId", users1.getUserid());
                    setSessionAttr("vmmisuser", users1);
                    System.out.println("vmmisuser: " + users1);

                    String requestPathA = getSessionAttr("requestPathA");
                    System.out.println("LoginController_determine_requestPathA: " + requestPathA);

//                    getRequest().getContextPath();
                    if ("/yile/login".equals(getRequest().getContextPath())) {
                        renderJson("requestPathA", "/yile/home");
                    } else {
                        renderJson("requestPathA", "/yile/home");
                        //renderJson("requestPathA", getSessionAttr("requestPathA"));
                    }
                }
            }
        } else {
            renderJson("enterAgain", ENTER_AGAIN);
        }
    }
}
