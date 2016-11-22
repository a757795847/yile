package com.jfinal.weixin.controller.login;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.kit.StrKit;
import com.jfinal.others.MyCaptchaRender;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.List;

import static jxl.biff.FormatRecord.logger;

/**
 * Created by zengriyong on 16/11/11.
 */
public class LoginController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

//    @ActionKey("/login")
    @Before(UserAuthInterceptor.class)
    public void index() {
        render("/views/pepsi/login.jsp");
    }

    @ActionKey("/login/post")
    @Before(UserAuthInterceptor.class)
    public void determine() throws Exception {
        String userId = getSessionAttr("userId");
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
            List<Vmmisuser> users1 = Vmmisuser.dao.find(sql1, userName, password);
            if (users1.size() == 0) {
                renderJson("user_error", "用户名或密码错误！");
            } else if (validate == false) {
                renderJson("msg_error", "验证码错误");
            } else {
                String sql2 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and pwderrorcount >= '4'";
                List<Vmmisuser> users2 = Vmmisuser.dao.find(sql2, userName, password);
                String sql3 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and `status` = '1'";
                List<Vmmisuser> users3 = Vmmisuser.dao.find(sql3, userName, password);

                if (users2.size() > 0) {
                    renderJson("psd_beyond", "该用户连续输错4次密码，已被锁定！你可以到VM后台电脑端‘登录页面’【取回密码】来解锁和获取新的密码！");
                } else if (users3.size() > 0) {
                    renderJson("user_disable", "该用户已被停用！");
                } else {

                    //正常登录
                    String RememberPwd = getPara("RememberPwd");
                    if (StrKit.notBlank(RememberPwd)) {

                        Cipher cipher = Cipher.getInstance("AES");
                        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
                        setSessionAttr("AESKEY", key);
                        cipher.init(Cipher.ENCRYPT_MODE, key);
                        byte[] result = cipher.doFinal(password.getBytes());
                        logger.debug(new String(result));

                        //记住密码
                        setCookie("username", userName, 1209600);
//                        setCookie("password", new String(result), 1209600);
                    }
                    String AutomaticLogin = getPara("AutomaticLogin");
                    if (StrKit.notBlank(AutomaticLogin)) {
                        //自动登录(1、session取openId; 2、调用接口存openId)
                        String openId = getSessionAttr("openId");
                        //todo 2、调用接口存openId

                    }


                    setSessionAttr("userId", userId);

                    String requestPathA = getSessionAttr("requestPathA");
                    System.out.println("requestPathA: " + requestPathA);


                    if ("http://localhost:8080/login".equals(requestPathA) || "http://wechat.izhuiyou.com/login".equals(requestPathA)) {
                        renderJson("requestPathA", "http://localhost:8080/home");
                    } else {
                        renderJson("requestPathA", getSessionAttr("requestPathA"));
                    }


                }
            }


        } else {
            renderJson("enterAgain", "请输入完整信息！");
        }
    }

/*    @Before(UserAuthInterceptor.class)
    public void index() throws Exception {
        String userId = getSessionAttr("userId");
        String userName = getPara("username");
        String password = getPara("password");
        String inputRandomCode = getPara("captcha");
        logger.debug("userName: " + userName + " , password: " + password + ", captcha: " + inputRandomCode);

        boolean validate = MyCaptchaRender.validate(this, inputRandomCode);
        logger.debug("CaptchaRender.validate=" + validate + ";inputRandomCode=" + inputRandomCode);

        //todo sql 查询用户名密码是否正确
        String sql1 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and `status` != '1' and pwderrorcount < '4'";
        String sql2 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and pwderrorcount >= '4'";
        String sql3 = "select * from vmmisuser where loginname = ? and `password` = PASSWORD(?) and `status` = '1'";
        List<Vmmisuser> users1 = Vmmisuser.dao.find(sql1, userName, password);
        List<Vmmisuser> users2 = Vmmisuser.dao.find(sql2, userName, password);
        List<Vmmisuser> users3 = Vmmisuser.dao.find(sql3, userName, password);
        logger.debug("users1: " + users1);
        logger.debug("users2: " + users2);
        logger.debug("users3: " + users3);
        if (validate == false && StrKit.notBlank(inputRandomCode)) {
            renderJson("msg_error", "验证码错误");

        } else if (users1.size() > 0 && validate) {
            //正常登录
            String RememberPwd = getPara("RememberPwd");
            if (StrKit.notBlank(RememberPwd)) {

                Cipher cipher = Cipher.getInstance("AES");
                SecretKey key = KeyGenerator.getInstance("AES").generateKey();
                setSessionAttr("AESKEY", key);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] result = cipher.doFinal(password.getBytes());
                logger.debug(new String(result));

                //记住密码
                setCookie("username", userName, 1209600);
                setCookie("password", new String(result), 1209600);
            }
            String AutomaticLogin = getPara("AutomaticLogin");
            if (StrKit.notBlank(AutomaticLogin)) {
                //自动登录(1、session取openId; 2、调用接口存openId)
                String openId = getSessionAttr("openId");
                //todo 2、调用接口存openId

            }


            setSessionAttr("userId", userId);

            String requestPathA = getSessionAttr("requestPathA");
            System.out.println("requestPathA: " + requestPathA);
            renderJson("requestPathA", requestPathA);

        } else if (users1.size() == 0 && users2.size() > 0) {
            //提示用户“该用户连续输错4次密码，已被锁定！你可以到VM后台电脑端‘登录页面’【取回密码】来解锁和获取新的密码！”
            renderJson("psd_beyond", "该用户连续输错4次密码，已被锁定！你可以到VM后台电脑端‘登录页面’【取回密码】来解锁和获取新的密码！");

        } else if (users1.size() == 0 && users3.size() > 0) {
            //提示用户“该用户已被停用！”，并不允许用户登录；
            renderJson("user_disable", "该用户已被停用！");

        } else if (users1.size() > 0 && StrKit.isBlank(inputRandomCode)) {
            renderJson("msg_null", "请输入验证码！");
        } else {
            render("login.jsp");

        }*/


//        Boolean flag = false;
//        if (users1.size() > 0 && validate) {
//            //记住密码
//            setCookie("username", userName, 1209600);
//            setCookie("password", password, 1209600);
//            //自动登录(1、session取openId; 2、调用接口存openId)
//            String openId = getSessionAttr("openId");
//            //todo 2、调用接口存openId
//
//
//            setSessionAttr("userId", userId);
//
//            String requestPathA = getSessionAttr("requestPathA");
//            System.out.println("requestPathA: " + requestPathA);
//            renderJson("requestPathA", requestPathA);
////            redirect(requestPathA);
////            setAttr("test", "成功登录");
////            render("/jsp/login.jsp?1213");
//        } /*else if (userName != "123" && password != "111") {
//            renderError(1, "用户名或密码错误");
//        } else if (validate == false) {
////            setAttr("test", "用户名或密码错误");
////            renderJson("error", requestPathA);
////            render("/views/pepsi/login.html");
//            renderError(1, "验证码错误");
//        }*/ else {
//            render("/views/pepsi/login.html");
//        }


}
