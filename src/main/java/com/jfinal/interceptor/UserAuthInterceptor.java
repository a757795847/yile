package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

/**
 * Created by zengriyong on 16/11/11.
 */
public class UserAuthInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        String userId = controller.getSessionAttr("userId");
        if (StrKit.isBlank(userId)) {
            StringBuffer requestPathA = controller.getRequest().getRequestURL();
            controller.setSessionAttr("requestPathA", requestPathA.toString());
            inv.getController().redirect("http://wechat.izhuiyou.com/oauth2");
        } else {
            inv.invoke();
        }

    }
}
