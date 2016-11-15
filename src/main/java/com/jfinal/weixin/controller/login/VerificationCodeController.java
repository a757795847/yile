package com.jfinal.weixin.controller.login;

import com.jfinal.others.MyCaptchaRender;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

/**
 * Created by zengriyong on 16/11/15.
 */
public class VerificationCodeController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        render(new MyCaptchaRender(60, 22, 4, true));
    }
}
