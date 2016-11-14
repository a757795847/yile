package com.jfinal.weixin.test;

import com.jfinal.aop.Before;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

/**
 * Created by zengriyong on 16/11/11.
 */
public class TestController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    @Before(UserAuthInterceptor.class)
    public void index(){
        String userId = getSessionAttr("userId");
        setAttr("test", userId);
        render("/jsp/login.jsp");
    }
}
