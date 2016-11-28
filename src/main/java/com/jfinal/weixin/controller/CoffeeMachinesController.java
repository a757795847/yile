package com.jfinal.weixin.controller;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zengriyong on 16/11/25.
 */
public class CoffeeMachinesController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        String sql = "SELECT " +
                " concat( " +
                "  DATE_FORMAT( " +
                "   androidvmuserinfo.registdate , " +
                "   '%Y%m%d' " +
                "  ) , " +
                "  androidvmuserinfo.deviceid " +
                " ) AS rds , " +
                " sum(androidsalelist.price) prices , " +
                " count(androidsalelist.yyyymmdd) count1 , " +
                " androidnetinfo.lastnettime , " +
                " androidnetappstart.pkgname , " +
                " androidnetappstart.apkversion , " +
                " COUNT(androidcabineta.deviceid) counta , " +
                " COUNT(androidcabinetb.deviceid) countb , " +
                " COUNT(androidcabinetc.deviceid) countc , " +
                " COUNT(androidcabinetd.deviceid) countd , " +
                " COUNT(androidcabinete.deviceid) counte , " +
                " COUNT(androidtrackdouble.deviceid) count2 , " +
                " androidcoffee.* " +
                "FROM " +
                " androidcoffee " +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidcoffee.deviceid " +
                "AND androidvmuserinfo.vmcustomerid = ? " +
                "LEFT JOIN androidnetinfo ON androidnetinfo.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidtrackka ON androidtrackka.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidnetappstart ON androidnetappstart.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabineta ON androidcabineta.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinetb ON androidcabinetb.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinetc ON androidcabinetc.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinetd ON androidcabinetd.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinete ON androidcabinete.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidtrackdouble ON androidtrackdouble.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidsalelist ON androidsalelist.deviceid = androidcoffee.deviceid " +
                "AND androidsalelist.yyyymmdd = ? " +
                "GROUP BY " +
                " androidcoffee.deviceid , " +
                " androidsalelist.yyyymmdd " +
                "ORDER BY " +
                " rd DESC " +
                "LIMIT ?";

        String sql1 = "SELECT " +
                " concat( " +
                "  DATE_FORMAT( " +
                "   androidvmuserinfo.registdate , " +
                "   '%Y%m%d' " +
                "  ) , " +
                "  androidvmuserinfo.deviceid " +
                " ) AS rds , " +
                " sum(androidsalelist.price) prices , " +
                " count(androidsalelist.yyyymmdd) count1 , " +
                " androidnetinfo.lastnettime , " +
                " androidnetappstart.pkgname , " +
                " androidnetappstart.apkversion , " +
                " COUNT(androidcabineta.deviceid) counta , " +
                " COUNT(androidcabinetb.deviceid) countb , " +
                " COUNT(androidcabinetc.deviceid) countc , " +
                " COUNT(androidcabinetd.deviceid) countd , " +
                " COUNT(androidcabinete.deviceid) counte , " +
                " COUNT(androidtrackdouble.deviceid) count2 , " +
                " androidcoffee.* " +
                "FROM " +
                " androidcoffee " +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidcoffee.deviceid " +
                "AND androidvmuserinfo.vmcustomerid = ? " +
                "LEFT JOIN androidnetinfo ON androidnetinfo.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidtrackka ON androidtrackka.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidnetappstart ON androidnetappstart.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabineta ON androidcabineta.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinetb ON androidcabinetb.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinetc ON androidcabinetc.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinetd ON androidcabinetd.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidcabinete ON androidcabinete.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidtrackdouble ON androidtrackdouble.deviceid = androidcoffee.deviceid " +
                "LEFT JOIN androidsalelist ON androidsalelist.deviceid = androidcoffee.deviceid " +
                "AND androidsalelist.yyyymmdd = ? " +
                "WHERE concat( \" + " +
                "                \"  DATE_FORMAT( \" + " +
                "                \"   androidvmuserinfo.registdate , \" + " +
                "                \"   '%Y%m%d' \" + " +
                "                \"  ) , \" + " +
                "                \"  androidvmuserinfo.deviceid \" + " +
                "                \" ) < ?" +
                "GROUP BY " +
                " androidcoffee.deviceid , " +
                " androidsalelist.yyyymmdd " +
                "ORDER BY " +
                " rd DESC " +
                "LIMIT ?";

        String today = DateTime.now().toString("yyyy-MM-dd");
        Vmmisuser vmmisuser = getSessionAttr("vmmisuser");
        System.out.println("DrinkMachinesController_vmmisuser: " + vmmisuser);
        String rd = getPara("rd");
        String rows = getPara("rows");
        System.out.println("rd: " + rd + ", rows: " + rows);

        List<Record> data;
        if (StrKit.notBlank(rd) && StrKit.notBlank(rows)) {

            data = Db.find(sql1, vmmisuser.getVmcustomerid(), today, rd, rows);

        } else if (StrKit.isBlank(rd) && StrKit.notBlank(rows)) {

            data = Db.find(sql, vmmisuser.getVmcustomerid(), today, rows);

        } else if (StrKit.notBlank(rd) && StrKit.isBlank(rows)) {

            data = Db.find(sql1, vmmisuser.getVmcustomerid(), today, rd, 50);
        } else {

            data = Db.find(sql, vmmisuser.getVmcustomerid(), today, 50);
        }

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int n = 0; n < data.size(); n++) {
            String deviceid = data.get(n).getStr("deviceid");
            String vmname = data.get(n).getStr("vmname");
            String billstatus = data.get(n).get("billstatus").toString();
            String coinstatus = data.get(n).get("coinstatus").toString();
            String types = data.get(n).get("type").toString();
            String errorstr = data.get(n).get("errorstr").toString();
            String coffeetemp = data.get(n).get("coffeetemp").toString();
            String keeptemp = data.get(n).get("keeptemp").toString();
            String oneyuannum = data.get(n).get("oneyuannum").toString();
            String fivejiaonum = data.get(n).get("fivejiaonum").toString();
            String rds = data.get(n).get("rds").toString();

            if (StrKit.isBlank(vmname)) {
                vmname = "未设定";
            }

            if ("0".equals(types)) {
                types = "307";
            } else if ("1".equals(types)) {
                types = "308-B";
            } else {
                types = "308-C";
            }

            int coffeeNum = 0;
            for (int i = 1; i <= 16; i++) {
                coffeeNum += data.get(n).getInt("coffee" + i + "is");
            }

            String foldname = "";
            for (int i = 1; i <= 5; i++) {
                if (i == 5) {
                    foldname += data.get(n).get("fold" + i + "name");
                } else {
                    foldname += data.get(n).get("fold" + i + "name") + "/";
                }
            }

            String prices = "";
            if (data.get(n).get("prices") != null) {
                prices = data.get(n).get("prices").toString();
            }

            String count1 = data.get(n).getLong("count1").toString();
            if ("0".equals(count1)) {
                count1 = "--";
            }

            String pkgname = data.get(n).getStr("pkgname");
            Long counta = data.get(n).get("counta");
            Long countb = data.get(n).get("countb");
            Long countc = data.get(n).get("countc");
            Long countd = data.get(n).get("countd");
            Long counte = data.get(n).get("counte");
            Long count2 = data.get(n).get("count2");

            String apkversion = data.get(n).get("apkversion").toString();
            String apkversionStr = "";
            if (StrKit.notBlank(apkversion)) {
                for (int i = 0; i < apkversion.length(); i++) {
                    if (i == apkversion.length() - 1) {
                        apkversionStr += apkversion.substring(i, i + 1);
                        break;
                    } else {
                        apkversionStr += apkversion.substring(i, i + 1);
                        apkversionStr += ".";
                    }
                }
            }

            String liantiji = "";
            if (count2 > 0) {
                liantiji = "连";
            }

            String guizi = "";
            if (counta > 0) {
                guizi += "A";
            }
            if (countb > 0) {
                guizi += "B";
            }
            if (countc > 0) {
                guizi += "C";
            }
            if (countd > 0) {
                guizi += "D";
            }
            if (counte > 0) {
                guizi += "E";
            }


            HashMap<String, String> item = new HashMap<String, String>();

            item.put("deviceid", deviceid); //设备id
            item.put("vmname", vmname); //机器名称
            item.put("lastnettime", data.get(n).getTimestamp("lastnettime").toString()); //联网状态
            item.put("billstatus", billstatus); //纸币
            item.put("coinstatus", coinstatus); //硬币找零
            item.put("number", oneyuannum + "/" + fivejiaonum); //一元五角个数
            item.put("types", types); //机器类型
            item.put("errorstr", errorstr); //故障信息
            item.put("coffeeNum", coffeeNum + ""); //咖啡品种
            item.put("today", prices + "/" + count1); //今日(金额/次数)
            item.put("foldname", foldname); //料盒
            item.put("temp", coffeetemp + "/" + keeptemp); //咖啡温度/保持温度
            item.put("guizi/liantiji", guizi + liantiji); //柜子/连体机
            item.put("version", IntegratedMachineController.transformVM(pkgname) + "/" + apkversionStr); //版本
            item.put("rd", rds);

            list.add(item);

        }
        renderJson(list);
    }
}
