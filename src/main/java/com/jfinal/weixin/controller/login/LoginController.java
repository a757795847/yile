package com.jfinal.weixin.controller.login;

import com.jfinal.aop.Before;
import com.jfinal.interceptor.LoginValidator;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.others.MyCaptchaRender;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import static jxl.biff.FormatRecord.logger;

/**
 * Created by zengriyong on 16/11/11.
 */
public class LoginController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    @Before(UserAuthInterceptor.class)
    public void index() {
        String userId = getSessionAttr("userId");
//        String userName = getSessionAttr("userName");
//        String password = getSessionAttr("password");

        String userName = getPara("username");
        String password = getPara("password");
        logger.debug("userName: " + userName + " , password: " + password);
        String inputRandomCode = getPara("captcha");
        boolean validate = MyCaptchaRender.validate(this, inputRandomCode);

        logger.debug("CaptchaRender.validate=" + validate + ";inputRandomCode=" + inputRandomCode);

        //todo sql 查询用户名密码是否正确
        Boolean flag = false;//假定正确
        if (userName != null) {
            //记住密码
            setCookie("sessionId", password, 600);
            //自动登录(1、session取openId; 2、调用接口存openId)
            String openId = getSessionAttr("openId");
            //todo 2、调用接口存openId


            setSessionAttr("userId", userId);

            String requestPathA = getSessionAttr("requestPathA");
            renderJson("requestPathA", requestPathA);
//            redirect(requestPathA);
//            setAttr("test", "成功登录");
//            render("/jsp/login.jsp?1213");
        } else {
            setAttr("test", "用户名或密码错误");
            render("/jsp/login.jsp");
        }

    }

//    @Before(LoginValidator.class)
//    public void index() {
//        render("/jsp/login.jsp");
////        render("/views/pepsi/login.html");
//    }


}
