package com.jfinal.weixin.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import java.math.BigInteger;

import static com.jfinal.others.Constant.ADD_DEVICE;

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

        Vmmisuser vmmisuser111 = getSessionAttr("vmmisuser");
        BigInteger vmcustomerid = vmmisuser111.getVmcustomerid();
        String realName = vmmisuser111.getRealname();
        String loginName = vmmisuser111.getLoginname();
        System.out.println("AddDeviceController_vmcustomerid: " + vmcustomerid + ", realName: " + realName + ", loginName: " + loginName);

        if (StrKit.notBlank(deviceId) && StrKit.notBlank(deviceModel) && StrKit.notBlank(deviceData)) {
            //把这三个数据存入数据库中

            String url = "http://115.29.179.158/vmmis/addAndroidVmuserinfo?vmcustomerid=" + vmcustomerid + "&deviceid=" + deviceId + "&model=" + deviceModel + "&registdate=" + deviceData + "&registrealname=" + realName + "&loginname=" + loginName;
            System.out.println("AddDeviceController_url: " + url);
            String str = HttpKit.get(url);
            System.out.println("AddDeviceController_str: " + str);
            String a[] = str.split(",");
            System.out.println(a[0]);

//            Boolean flag = true;
            if ("1".equals(a[0])) {
                renderJson("success", a[1]);
            } else {
                renderJson("failed", a[1]);
            }
        } else {
            renderJson("error", "请输入完整信息");
        }
    }

}
