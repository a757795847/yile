package com.jfinal.weixin.controller;

import com.jfinal.aop.Before;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.models.Vmcustomerinfo;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by zengriyong on 16/11/15.
 */
public class HomePageController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    @Before(UserAuthInterceptor.class)
    public void index() {
        //根据userId 获取 vmmisuser 表中的 vmcustomerid 和 authority
        //根据vmcustomerid 获取 vmcustomerinfo 表中的 proxy
        // 如果authority != 4 并且 proxy = 1, 才可以添加上位机(往session中添加字段allowsAdd, true为允许,false为不允许)
        BigInteger userId = getSessionAttr("userId");
        System.out.println("HomePageController_userId: " + userId);
        Vmmisuser user = Vmmisuser.dao.findByIdLoadColumns(userId, "vmcustomerid, authority");

        String vmcustomerid = user.getVmcustomerid().toString();
        String authority = user.getAuthority().toString();

        System.out.println("vmcustomerid: " + user.getVmcustomerid() + ", authority: " + user.getAuthority());

        if (StrKit.notBlank(vmcustomerid)) {
            Vmcustomerinfo vmcustomerinfo = Vmcustomerinfo.dao.findById(vmcustomerid);
            System.out.println("vmcustomerinfo: " + vmcustomerinfo);
            String proxy = vmcustomerinfo.getProxy().toString();
            System.out.println("proxy: " + proxy);

            if (StrKit.notBlank(proxy) && "1".equals(proxy) && authority != "4") {
                setSessionAttr("allowsAdd", true);
            } else {
                setSessionAttr("allowsAdd", false);
            }
            render("index.jsp");
        } else {
            //Todo 如果没有找到vmcustomerid。。。

        }
    }

}
