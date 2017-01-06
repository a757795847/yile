package com.jfinal.weixin.controller;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.models.SysUserRoleMst;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimePrinter;

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
                "    DATE_FORMAT(p.inserttime , '%Y%m%d%H%i%s') ,  " +
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
                "AND u.vmcustomerid = ?  " +
                "ORDER BY  " +
                "  rds DESC  " +
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
                "    DATE_FORMAT(p.inserttime , '%Y%m%d%H%i%s') ,  " +
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
                "AND u.vmcustomerid = ?  " +
                "AND concat(  " +
                "    DATE_FORMAT(p.inserttime , '%Y%c%d') ,  " +
                "    p.tranid  " +
                "  ) < ?  " +
                "ORDER BY  " +
                "  rds DESC  " +
                "LIMIT 30";

        Vmmisuser vmmisuser = getSessionAttr("vmmisuser");
        System.out.println("NonCash_vmmisuser: " + vmmisuser);
        String rd = getPara("rd");

        String time = DateTime.now().toString("yyyy-MM-dd");
        Date time2 = null;
        DateTime dt2_minusOneMonth = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");
        Date dt = null;
        Date dt1 = null;
        DateTime dt_parsed = DateTime.now();
        Calendar specialDate = Calendar.getInstance();
        Calendar specialDate2 = Calendar.getInstance();

        if (StrKit.notBlank(rd)) {
            time = rd.substring(0, 8);

            dt_parsed = DateTime.parse(time, dateTimeFormatter);

        }

        dt2_minusOneMonth = dt_parsed.minusMonths(1).withDayOfMonth(1);

        System.out.println("time: " + time + ", dt: " + dt + ", dt1: " + dt1);
        System.out.println("rd: " + rd);
        System.out.println("dt1: " + dt1);
        System.out.println("time2: " + time2);

        System.out.println("dt parse: " + dt_parsed);
        System.out.println("dt minus one month : " + dt2_minusOneMonth);

        System.out.println("1:::" + new Date());
        int searchInterval = 3;
        List<Record> data = new ArrayList<Record>();
        if (StrKit.notBlank(rd) && StrKit.notBlank(time)) {

            while (data.size() < 30 && dt_parsed.isAfter(dt2_minusOneMonth)) {
                DateTime dt_parse_minusThreeDay = dt_parsed.minusDays(searchInterval);
                data.addAll(Db.find(sql1, dt_parse_minusThreeDay.toDate(), dt_parsed.toDate(), vmmisuser.getVmcustomerid(), rd));
                System.out.println("data1: " + data);
                dt_parsed = dt_parsed.minusDays(searchInterval);
                if (data.size() == 0) {
                    searchInterval += 3;
                }
            }
        } else {
            while (data.size() < 30 && dt_parsed.isAfter(dt2_minusOneMonth)) {
                DateTime dt_parse_minusThreeDay = dt_parsed.minusDays(searchInterval);
                data.addAll(Db.find(sql, dt_parse_minusThreeDay.toDate(), dt_parsed.toDate(), vmmisuser.getVmcustomerid()));
                System.out.println("data2: " + data);

                dt_parsed = dt_parsed.minusDays(searchInterval);
                if (data.size() == 0) {
                    searchInterval += 3;
                }
            }
        }
        data = data.subList(0, Math.min(30, data.size()));
        System.out.println("data: " + data);
        System.out.println("2:::" + new Date());

        for (Record r : data) {
            System.out.println("r: " + r);
        }


        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int n = 0; n < data.size(); n++) {
            String deviceid = data.get(n).get("deviceid", "").toString();
            String inserttime = data.get(n).get("inserttime", "").toString();
            String price = data.get(n).get("price", "").toString();
            String name = data.get(n).get("name", "").toString();
            String owner = data.get(n).get("owner", "").toString();

            String tranid = data.get(n).get("tranid", "").toString();
            String openid = data.get(n).get("openid", "").toString();
            String trackno = data.get(n).get("trackno", "").toString();
            String stranid = data.get(n).get("stranid", "").toString();
            String rds = data.get(n).get("rds").toString();

            String vmname = data.get(n).get("vmname", "").toString();
            String vmnamet = data.get(n).get("vmnamet", "").toString();
            String qvmname = data.get(n).get("qvmname", "").toString();

            if (StrKit.isBlank(name)) {
                name = owner;
            }

            String noncashName = "";
            if (StrKit.notBlank(vmname)) {
                noncashName = vmname;
            } else if (StrKit.notBlank(vmnamet)) {
                noncashName = vmnamet;
            } else if (StrKit.notBlank(qvmname)) {
                noncashName = qvmname;
            } else {
                noncashName = "未定义机器名";
            }


            HashMap<String, String> item = new HashMap<String, String>();

            item.put("deviceid", deviceid);
            item.put("saletime", inserttime);
            item.put("price", price);
            item.put("name", name);
            item.put("tranid", tranid);
            item.put("openid", openid);
            item.put("trackno", trackno);
            item.put("stranid", stranid);// 数据存在显示'有'，否则显示'退款处理'
            item.put("rd", rds);
            item.put("noncashName", noncashName);

            list.add(item);

        }
        renderJson(list);

    }
}