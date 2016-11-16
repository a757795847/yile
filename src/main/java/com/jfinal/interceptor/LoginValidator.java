package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.validate.Validator;


/**
 * Created by zengriyong on 16/11/14.
 */
public class LoginValidator implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        if (controller.getSession() == null) {
            inv.getController().redirect("/login");
        } else {
            String username = controller.getPara("username");
            String password = controller.getPara("password");
            String captcha = controller.getPara("captcha");
            System.out.println("username: " + username);
            System.out.println("password: " + password);
            System.out.println("captcha: " + captcha);
            //todo 进行数据库查询
            if (username != null && password != null) {
                //用户名密码正确时,进入首页
                System.out.println("LoginValidator_1111");
                inv.getController().redirect("/home");
//                inv.invoke();
            } else {
//                inv.getController().redirect("/login");
                //用户名密码错误时,重新进入login页面
                inv.invoke();
            }
        }
    }
}
