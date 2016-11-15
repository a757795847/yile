package com.jfinal.interceptor;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.validate.Validator;


/**
 * Created by zengriyong on 16/11/14.
 */
public class LoginValidator extends Validator {

    private static final String msg = "message";

    protected void validate(Controller c) {
        setShortCircuit(true);
        validateRequired("user_name", msg, "请您输入用户名!");
        validateRequired("password", msg, "请您输入密码!");
        validateRequired("randomCode", msg, "请您输入验证码!");

        String inputRandomCode = c.getPara("randomCode");
        if (StrKit.isBlank(inputRandomCode))
            inputRandomCode = inputRandomCode.toUpperCase();

        String systemRandomCode = c.getCookie("systemRandomCode");
//        if (RandomCodeService.validate(inputRandomCode, systemRandomCode) == false) {
//            addError(msg, "验证码输入不正确,请重新输入!");
//        }
    }

    protected void handleError(Controller c) {
        c.keepPara();
        c.render("/common/login.html");
    }
}
