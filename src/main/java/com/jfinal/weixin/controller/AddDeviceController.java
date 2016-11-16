package com.jfinal.weixin.controller;

import com.jfinal.aop.Before;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

/**
 * Created by zengriyong on 16/11/16.
 */
public class AddDeviceController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        String deviceId = getPara("deviceId");
        String deviceModel = getPara("deviceModel");
        String deviceData = getPara("deviceData");
        //TODO 把这三个数据存入数据库中

        if (true) {

        } else {

        }
    }

}
