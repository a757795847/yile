package com.jfinal.weixin.weboauth2;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;

import java.io.IOException;

import static com.jfinal.weixin.sdk.api.ApiConfigKit.getApiConfig;

/**
 * Created by zengriyong on 16/11/10.
 */
//test
public class WeChatAuthenticationSupport implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        String appId = getApiConfig().getAppId();
        try {

            // 判断请求的controller是否带有微信返回的code参数，如果没有就调用微信授权接口获取code参数
            if (controller.isParaBlank("code")) {
                final String scope = "snsapi_base";
                //当前正在访问的路径地址
                final StringBuffer requestPath = controller.getRequest().getRequestURL();
                //组装成微信接口调用地址
                String resultUrl = SnsAccessTokenApi.getAuthorizeURL(appId, requestPath.toString(), true);
                System.out.println("resultUrl: " + resultUrl);
                try {
                    //请求微信接口地址
                    controller.getResponse().sendRedirect(resultUrl);
                    String code = inv.getController().getPara("code");
                    System.out.println("code121: " + code );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            inv.invoke();
        } finally {
            ApiConfigKit.removeThreadLocalApiConfig();
        }
    }
}
