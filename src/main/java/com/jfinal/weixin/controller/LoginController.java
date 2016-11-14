package com.jfinal.weixin.controller;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

/**
 * Created by zengriyong on 16/11/11.
 */
public class LoginController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        String userId = getSessionAttr("userId");
        String userName = getSessionAttr("userName");
        String password = getSessionAttr("password");
        //todo sql 查询用户名密码是否正确
        Boolean flag = true;//假定正确
        if (flag) {
            //记住密码
            setCookie("sessionId", password, 600);
            //自动登录(1、session取openId; 2、调用接口存openId)
            String openId = getSessionAttr("openId");
            //todo 2、调用接口存openId


            setSessionAttr("userId", userId);

            String requestPathA = getSessionAttr("requestPathA");
            redirect(requestPathA);
        } else {
            setAttr("test", "用户名或密码错误");
            render("login.jsp");
        }

    }

}
