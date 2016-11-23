package com.jfinal.weixin.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.weixin.models.Vmcustomerinfo;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import java.math.BigInteger;

/**
 * Created by zengriyong on 16/11/16.
 */
public class DeviceController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    @Before(UserAuthInterceptor.class)
    public void index() {
        BigInteger userId = getSessionAttr("userId");
        System.out.println("userId: " + userId);
        Vmmisuser vmmisuser = Vmmisuser.dao.findById(userId);
        Vmcustomerinfo vmcustomerinfo = Vmcustomerinfo.dao.findById(vmmisuser.getVmcustomerid());
        String dname = vmcustomerinfo.getName();
        setSessionAttr("dname", dname);
        render("onmachine.jsp");
    }


}
