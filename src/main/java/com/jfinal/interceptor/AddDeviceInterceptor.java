package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.models.Vmcustomerinfo;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

/**
 * Created by zengriyong on 16/11/21.
 */
public class AddDeviceInterceptor extends ApiController implements Interceptor {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        String userId = controller.getSessionAttr("userId");
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
                renderJson("allowsAdd", true);
            } else {
                renderJson("allowsAdd", false);
            }
            inv.invoke();
        }else {
            //Todo 如果没有找到vmcustomerid。。。

        }

    }
}
