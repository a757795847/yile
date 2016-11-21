package com.jfinal.weixin.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;


/**
 * Created by zengriyong on 16/11/17.
 */
public class GeneralStatusController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    @Before(UserAuthInterceptor.class)
    public void index() {
        render("index.jsp");
    }


    @ActionKey("/machine/integrated")
    public void integrated(){
        render("machine_state.jsp");
    }

    @ActionKey("/machine/drinks")
    public void drinks(){
        render("");
    }

    @ActionKey("/machine/coffee")
    public void coffee(){
        render("");
    }

}
