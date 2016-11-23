package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

import java.math.BigInteger;

/**
 * Created by zengriyong on 16/11/11.
 */
public class UserAuthInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        BigInteger userId = controller.getSessionAttr("userId");
        System.out.println("UserAuthInterceptor_intercept_userId: " + userId);
        if ("".equals(userId) || userId == null) {
            Boolean debug = false;
            if (debug) {
                StringBuffer requestPathA = controller.getRequest().getRequestURL();
                controller.setSessionAttr("requestPathA", requestPathA.toString());
                System.out.println("UserAuthInterceptor_if_requestPathA: " + requestPathA);
                controller.setSessionAttr("userId", "72");
                controller.setSessionAttr("openId", "oLCXfwmSwiAfcgiEyJoy6RY3i24s");
                controller.setSessionAttr("token", "S4bapYUP6IhaZTXSZuz8XA1x6t2h6MWxJYTCbj2aBw_ODMaSMEd2-XqvdJNBQX-DyYVntPtYygujESeopcASsyqYI211gyBgqV523bzz4c");
                inv.invoke();
            } else {
                StringBuffer requestPathA = controller.getRequest().getRequestURL();
                controller.setSessionAttr("requestPathA", requestPathA.toString());
                System.out.println("UserAuthInterceptor_else_requestPathA: " + requestPathA);
                inv.getController().redirect("http://yile.izhuiyou.com/oauth2");
            }
        } else {
            inv.invoke();
        }

    }
}
