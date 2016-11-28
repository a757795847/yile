package com.jfinal.weixin.controller;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zengriyong on 16/11/25.
 */
public class NonCashPaymentController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        String sql = "SELECT  " +
                "  u.vmcustomerid ,  " +
                "  i.sname ,  " +
                "  o.`name` ,  " +
                "  p.`owner` ,  " +
                "  date_format(s.saletime , '%Y-%m-%d %H:%i:%s') AS saletime ,  " +
                "  date_format(  " +
                "    p.inserttime ,  " +
                "    '%Y-%m-%d %H:%i:%s'  " +
                "  ) AS inserttime ,  " +
                "  concat(  " +
                "    DATE_FORMAT(p.inserttime , '%Y%c%d') ,  " +
                "    p.tranid  " +
                "  ) AS rds ,  " +
                "  p.deviceid ,  " +
                "  a.vmcode ,  " +
                "  a.vmname ,  " +
                "  p.payway ,  " +
                "  p.tranid ,  " +
                "  s.tranid stranid,  " +
                "  p.openid ,  " +
                "  p.trackno ,  " +
                "  p.price ,  " +
                "  p.realname ,  " +
                "  t.vmname vmnamet ,  " +
                "  q.vmname qvmname  " +
                "FROM  " +
                "  androidvmuserinfo u ,  " +
                "  vmcustomerinfo i ,  " +
                "  vmcustomerproxy proxy ,  " +
                "  payok p  " +
                "LEFT JOIN androidsalelist s ON p.tranid = s.tranid  " +
                "LEFT JOIN androidsetpara a ON p.deviceid = a.deviceid  " +
                "LEFT JOIN androidguangone t ON p.deviceid = t.deviceid  " +
                "LEFT JOIN androidcoffee q ON p.deviceid = q.deviceid  " +
                "LEFT JOIN payowner o ON p.`owner` = o.`owner`  " +
                "WHERE  " +
                "  p.deviceid = u.deviceid  " +
                "AND u.vmcustomerid = i.id  " +
                "AND p.yyyymmdd >= ?  " +
                "AND p.yyyymmdd <= ?  " +
                "AND proxy.slaveid = u.vmcustomerid  " +
                "AND proxy.masterid = ?  " +
                "ORDER BY  " +
                "  rd DESC  " +
                "LIMIT 30";

        String sql1 = "SELECT  " +
                "  u.vmcustomerid ,  " +
                "  i.sname ,  " +
                "  o.`name` ,  " +
                "  p.`owner` ,  " +
                "  date_format(s.saletime , '%Y-%m-%d %H:%i:%s') AS saletime ,  " +
                "  date_format(  " +
                "    p.inserttime ,  " +
                "    '%Y-%m-%d %H:%i:%s'  " +
                "  ) AS inserttime ,  " +
                "  concat(  " +
                "    DATE_FORMAT(p.inserttime , '%Y%c%d') ,  " +
                "    p.tranid  " +
                "  ) AS rds ,  " +
                "  p.deviceid ,  " +
                "  a.vmcode ,  " +
                "  a.vmname ,  " +
                "  p.payway ,  " +
                "  p.tranid ,  " +
                "  s.tranid stranid,  " +
                "  p.openid ,  " +
                "  p.trackno ,  " +
                "  p.price ,  " +
                "  p.realname ,  " +
                "  t.vmname vmnamet ,  " +
                "  q.vmname qvmname  " +
                "FROM  " +
                "  androidvmuserinfo u ,  " +
                "  vmcustomerinfo i ,  " +
                "  vmcustomerproxy proxy ,  " +
                "  payok p  " +
                "LEFT JOIN androidsalelist s ON p.tranid = s.tranid  " +
                "LEFT JOIN androidsetpara a ON p.deviceid = a.deviceid  " +
                "LEFT JOIN androidguangone t ON p.deviceid = t.deviceid  " +
                "LEFT JOIN androidcoffee q ON p.deviceid = q.deviceid  " +
                "LEFT JOIN payowner o ON p.`owner` = o.`owner`  " +
                "WHERE  " +
                "  p.deviceid = u.deviceid  " +
                "AND u.vmcustomerid = i.id  " +
                "AND p.yyyymmdd >= ?  " +
                "AND p.yyyymmdd <= ?  " +
                "AND proxy.slaveid = u.vmcustomerid  " +
                "AND proxy.masterid = ?  " +
                "AND concat(  " +
                "    DATE_FORMAT(p.inserttime , '%Y%c%d') ,  " +
                "    p.tranid  " +
                "  ) < ?  " +
                "ORDER BY  " +
                "  rd DESC  " +
                "LIMIT 30";

        Vmmisuser vmmisuser = getSessionAttr("vmmisuser");
        System.out.println("NonCash_vmmisuser: " + vmmisuser);
        String rd = getPara("rd");

        String time = DateTime.now().toString("yyyy-MM-dd");
        Date time2 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        Date dt1 = null;
        Calendar specialDate = Calendar.getInstance();
        Calendar specialDate2 = Calendar.getInstance();
        try {
            if (StrKit.notBlank(rd)) {
                time = rd.substring(0, 7);
                dt = sdf.parse(time);
                specialDate.setTime(dt);
                specialDate.add(Calendar.DAY_OF_MONTH, -3);
                dt1 = specialDate.getTime();
            } else {
                specialDate.setTime(sdf.parse(time));
                specialDate.add(Calendar.DAY_OF_MONTH, -3);
                dt1 = specialDate.getTime();
            }
            specialDate2.setTime(sdf.parse(time));
            specialDate2.add(Calendar.MONTH, -1);
            time2 = specialDate2.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("time: " + time + ", dt: " + dt + ", dt1: " + dt1);
        System.out.println("rd: " + rd);

        List<Record> data;
        if (StrKit.notBlank(rd) && StrKit.notBlank(time)) {
            data = Db.find(sql1, dt1, dt, vmmisuser.getVmcustomerid(), rd);
            while (data.size() < 30 && dt1.after(time2)) {
                specialDate.setTime(dt1);
                specialDate.add(Calendar.DAY_OF_MONTH, -3);
                dt1 = specialDate.getTime();
                data = Db.find(sql1, dt1, dt, vmmisuser.getVmcustomerid(), rd);
            }
        } else {
//            data = Db.find(sql, dt1, time, vmmisuser.getVmcustomerid());
            data = Db.find(sql, dt1, time, 1);
            while (data.size() < 30 && dt1.after(time2)) {
                specialDate.setTime(dt1);
                specialDate.add(Calendar.DAY_OF_MONTH, -3);
                dt1 = specialDate.getTime();
//                data = Db.find(sql, dt1, time, vmmisuser.getVmcustomerid());
                data = Db.find(sql, dt1, time, 1);
            }
        }


        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int n = 0; n < data.size(); n++) {
            String deviceid = data.get(n).get("deviceid").toString();
            String saletime = data.get(n).get("saletime").toString();
            String price = data.get(n).get("price").toString();
            String name = data.get(n).get("name").toString();
            String tranid = data.get(n).get("tranid").toString();
            String openid = data.get(n).get("openid").toString();
            String trackno = data.get(n).get("trackno").toString();
            String stranid = data.get(n).get("stranid").toString();
            String rds = data.get(n).get("rds").toString();


            HashMap<String, String> item = new HashMap<String, String>();

            item.put("deviceid", deviceid);
            item.put("saletime", saletime);
            item.put("price", price);
            item.put("name", name);
            item.put("tranid", tranid);
            item.put("openid", openid);
            item.put("trackno", trackno);
            item.put("stranid", stranid);// 数据存在显示'有'，否则显示'退款处理'
            item.put("rd", rds);

            list.add(item);

        }
        renderJson(list);

    }
}