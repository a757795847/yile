package com.jfinal.weixin.controller;

import com.jfinal.aop.Before;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.kit.StrKit;
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
        System.out.println("deviceId: " + deviceId + ", deviceModel: " + deviceModel + ", deviceData: " + deviceData);
        if (StrKit.notBlank(deviceId) && StrKit.notBlank(deviceModel) && StrKit.notBlank(deviceData)) {
            //TODO 把这三个数据存入数据库中

            Boolean flag = true;
            if (flag) {
                renderJson("success", "添加成功");
            } else {
                renderJson("failed", "添加失败");
            }

        } else {
            renderJson("error", "请输入完整信息");
        }
    }

}
