package com.jfinal.weixin.test;

import com.jfinal.aop.Before;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

/**
 * Created by zengriyong on 16/11/11.
 */
public class TestController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    //    @Before(UserAuthInterceptor.class)
    public void index() {
        String userId = getSessionAttr("userId");
        setAttr("test", userId);
        render("/index/index.jsp");
    }

    public static void main(String[] args) {
        String appId = "wx6d37f5d05a8d301f";
        String s = SnsAccessTokenApi.getAuthorizeURL(appId, "http://vmmis.levending.net/yile/oauth2", true);
        System.out.println(s);
    }
}
