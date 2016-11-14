package com.jfinal.weixin.weboauth2;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.sdk.api.SnsAccessToken;
import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;

/**
 * Created by zengriyong on 16/11/10.
 */
public class WeChatOauth2Interceptor extends RedirectUri implements Interceptor {

    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        String appId = getApiConfig().getAppId();
        String secret = getApiConfig().getAppSecret();
        String code = inv.getController().getPara("code");
        StringBuffer requestPath = controller.getRequest().getRequestURL();
        if (StrKit.isBlank(code)) {
            inv.getController().redirect(SnsAccessTokenApi.getAuthorizeURL(appId, requestPath.toString(), true));
        }else {
            System.out.println("intercept_code :" + code);
            SnsAccessToken snsAccessToken = SnsAccessTokenApi.getSnsAccessToken(appId, secret, code);

            String openId = snsAccessToken.getOpenid();
            String token = snsAccessToken.getAccessToken();
            System.out.println("openId: "+openId);
            if ("oLCXfwmSwiAfcgiEyJoy6RY3i24s".equals(openId)) {
                inv.invoke();
            } else {
                setAttr("test", "WeChatOauth2Interceptor_intercept: error");
                render("index.jsp");
            }
        }

    }



}
