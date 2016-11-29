package com.jfinal.weixin.weboauth2;

import com.jfinal.aop.Before;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

/**
 * Created by zengriyong on 16/11/10.
 */
public class WeChatAPIs extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    @Before(WeChatOauth2Interceptor.class)
    public void index() {
        /*String pwd = new StringBuilder("qweq1234123asda").reverse().toString();
        System.out.println("pwd: " + pwd);*/
        setAttr("test", "这里是WeChatAPIs_test");
        render("index.jsp");
    }
}
