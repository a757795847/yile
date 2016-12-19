package com.jfinal.weixin.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.interceptor.UserAuthInterceptor;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.models.Androidsetpara;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import java.math.BigInteger;
import java.util.List;


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


    @ActionKey("/yile/machine/integrated")
    public void integrated(){
        Vmmisuser vmmisuser = getSessionAttr("vmmisuser");
        String zhjSql = "SELECT " +
                "   COUNT(*) " +
                "FROM " +
                "   androidsetpara " +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidsetpara.deviceid " +
                "AND androidvmuserinfo.vmcustomerid = ?";
        List<Record> zhjData = Db.find(zhjSql, vmmisuser.getVmcustomerid());

        String yljSql = "SELECT " +
                "   COUNT(*) " +
                "FROM " +
                "   androidguangone " +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidguangone.deviceid " +
                "AND androidvmuserinfo.vmcustomerid = ?";
        List<Record> yljData = Db.find(yljSql, vmmisuser.getVmcustomerid());

        String kfjSql = "SELECT " +
                "   COUNT(*) " +
                "FROM " +
                "   androidcoffee " +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidcoffee.deviceid " +
                "AND androidvmuserinfo.vmcustomerid = ?";
        List<Record> kfjData = Db.find(kfjSql, vmmisuser.getVmcustomerid());

        if(zhjData.get(0).getLong("COUNT(*)") > 0){
            setSessionAttr("zongheji", true);
        }else {
            setSessionAttr("zongheji", false);
        }

        if(yljData.get(0).getLong("COUNT(*)") > 0){
            setSessionAttr("yinliaoji", true);
        }else {
            setSessionAttr("yinliaoji", false);
        }

        if(kfjData.get(0).getLong("COUNT(*)") > 0){
            setSessionAttr("kafeiji", true);
        }else {
            setSessionAttr("kafeiji", false);
        }

        render("machine_state.jsp");
    }

//    @ActionKey("/machine/drinks")
//    public void drinks(){
//        render("");
//    }
//
//    @ActionKey("/machine/coffee")
//    public void coffee(){
//        render("");
//    }

}
