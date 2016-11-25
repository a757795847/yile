package com.jfinal.weixin.controller;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;
import org.joda.time.DateTime;

import java.security.Timestamp;
import java.util.*;

/**
 * 饮料机数据
 * Created by zengriyong on 16/11/25.
 */
public class DrinkMachinesController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        String sql = "SELECT\n" +
                "concat(\n" +
                "                DATE_FORMAT(\n" +
                "                androidvmuserinfo.registdate ,\n" +
                "                '%Y%c%d'),\n" +
                "                androidvmuserinfo.deviceid\n" +
                "                ) AS rd,\n" +
                "sum(androidsalelist.price) prices ,\n" +
                "count(androidsalelist.yyyymmdd) count1 ,\n" +
                "androidnetinfo.lastnettime ,\n" +
                "androidnetappstart.pkgname ,\n" +
                "androidnetappstart.apkversion ,\n" +
                "COUNT(androidcabineta.deviceid) counta,\n" +
                "COUNT(androidcabinetb.deviceid) countb,\n" +
                "COUNT(androidcabinetc.deviceid) countc,\n" +
                "COUNT(androidcabinetd.deviceid) countd,\n" +
                "COUNT(androidcabinete.deviceid) counte,\n" +
                "COUNT(androidtrackdouble.deviceid) count2,\n" +
                "androidguangone.*\n" +
                "FROM\n" +
                "    androidguangone\n" +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidguangone.deviceid AND androidvmuserinfo.vmcustomerid = ?\n" +
                "LEFT JOIN androidnetinfo ON androidnetinfo.deviceid = androidguangone.deviceid \n" +
                "LEFT JOIN androidtrackka ON androidtrackka.deviceid = androidguangone.deviceid \n" +
                "LEFT JOIN androidnetappstart ON androidnetappstart.deviceid = androidguangone.deviceid \n" +
                "LEFT JOIN androidcabineta ON androidcabineta.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinetb ON androidcabinetb.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinetc ON androidcabinetc.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinetd ON androidcabinetd.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinete ON androidcabinete.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidtrackdouble ON androidtrackdouble.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidsalelist ON androidsalelist.deviceid = androidguangone.deviceid AND androidsalelist.yyyymmdd = ?\n" +
                "GROUP BY androidguangone.deviceid, androidsalelist.yyyymmdd\n" +
                "order by rd desc " +
                "LIMIT ?";

        String sql1 = "SELECT\n" +
                "concat(\n" +
                "                DATE_FORMAT(\n" +
                "                androidvmuserinfo.registdate ,\n" +
                "                '%Y%m%d'),\n" +
                "                androidvmuserinfo.deviceid\n" +
                "                ) AS rd,\n" +
                "sum(androidsalelist.price) prices ,\n" +
                "count(androidsalelist.yyyymmdd) count1 ,\n" +
                "androidnetinfo.lastnettime ,\n" +
                "androidnetappstart.pkgname ,\n" +
                "androidnetappstart.apkversion ,\n" +
                "COUNT(androidcabineta.deviceid) counta,\n" +
                "COUNT(androidcabinetb.deviceid) countb,\n" +
                "COUNT(androidcabinetc.deviceid) countc,\n" +
                "COUNT(androidcabinetd.deviceid) countd,\n" +
                "COUNT(androidcabinete.deviceid) counte,\n" +
                "COUNT(androidtrackdouble.deviceid) count2,\n" +
                "androidguangone.*\n" +
                "FROM\n" +
                "    androidguangone\n" +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidguangone.deviceid AND androidvmuserinfo.vmcustomerid = ?\n" +
                "LEFT JOIN androidnetinfo ON androidnetinfo.deviceid = androidguangone.deviceid \n" +
                "LEFT JOIN androidtrackka ON androidtrackka.deviceid = androidguangone.deviceid \n" +
                "LEFT JOIN androidnetappstart ON androidnetappstart.deviceid = androidguangone.deviceid \n" +
                "LEFT JOIN androidcabineta ON androidcabineta.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinetb ON androidcabinetb.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinetc ON androidcabinetc.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinetd ON androidcabinetd.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidcabinete ON androidcabinete.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidtrackdouble ON androidtrackdouble.deviceid = androidguangone.deviceid\n" +
                "LEFT JOIN androidsalelist ON androidsalelist.deviceid = androidguangone.deviceid AND androidsalelist.yyyymmdd = 2016-11-21\n" +
                "where concat(\n" +
                "                DATE_FORMAT(\n" +
                "                androidvmuserinfo.registdate ,\n" +
                "                '%Y%m%d'),\n" +
                "                androidvmuserinfo.deviceid\n" +
                "                ) < ?\n" +
                "GROUP BY androidguangone.deviceid, androidsalelist.yyyymmdd\n" +
                "order by rd desc LIMIT ?";
        String today = DateTime.now().toString("yyyy-MM-dd");
        Vmmisuser vmmisuser = getSessionAttr("vmmisuser");
        System.out.println("DrinkMachinesController_vmmisuser: " + vmmisuser);
        String rd = getPara("rd");
        System.out.println("DrinkMachinesController_rd: " + rd);

        List<Record> data;
        if (StrKit.notBlank(rd)) {
            System.out.println("DrinkMachinesController_111");
            data = Db.find(sql, vmmisuser.getVmcustomerid(), today, rd, 50);
        } else {
            System.out.println("DrinkMachinesController_222");
//            data = Db.find(sql1, vmmisuser.getVmcustomerid(), today, 50);
            data = Db.find(sql, 1, today, 50);
        }
        System.out.println("sql: " + sql);
        System.out.println("data: " + data);


        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int n = 0; n < data.size(); n++) {
            String deviceid = data.get(n).getStr("deviceid");
            String vmname = data.get(n).getStr("vmname");
            String doorstatus = data.get(n).get("doorstatus").toString();
            String types = data.get(n).get("type").toString(); //0:光脚一号(7或20料道)，1:206-B大屏，2:206-B小屏
            String lefttempnow = data.get(n).get("lefttempnow").toString();
            String righttempnow = data.get(n).get("righttempnow").toString();
            String tempstatus = data.get(n).get("tempstatus").toString();
            String insidetempnow = data.get(n).get("insidetempnow").toString();
            String insidetempset = data.get(n).get("insidetempset").toString();
            String coininstatus = data.get(n).get("coininstatus").toString();
            String oneyuannum = data.get(n).get("oneyuannum").toString();
            String fivejiaonum = data.get(n).get("fivejiaonum").toString();
            int tracknum = data.get(n).getInt("tracknum");

            int guzhangguidaoNum = 0;
            int quehuoguidaoNum = 0;
            int kucunNum = 0;
            for (int i = 1; i <= tracknum; i++) {
                String trackstatus = "";
                int now = 0;
                int max = 0;
                if (i < 10) {
                    trackstatus = data.get(n).get("trackstatus0" + i).toString();
                    now = data.get(n).get("now0" + i);
                    max = data.get(n).get("max0" + i);
                } else {
                    trackstatus = data.get(n).get("trackstatus" + i).toString();
                    now = data.get(n).get("now" + i);
                    max = data.get(n).get("max" + i);
                }
                kucunNum += now;
                if ("0".equals(trackstatus)) {
                    guzhangguidaoNum++;
                } else if ("1".equals(trackstatus) && now < max) {
                    quehuoguidaoNum++;
                }

            }


            if (StrKit.isBlank(vmname)) {
                vmname = "未设定";
            }

            String number = "";
            if ("0".equals(types)) {
                lefttempnow = "-";
                righttempnow = "-";
                tempstatus = "-";
                insidetempnow = "-";
                insidetempset = "-";
                //一元五角的个数
                number = coininstatus;
            } else {
                number = oneyuannum + "/" + fivejiaonum;
            }

            if ("0".equals(doorstatus)) {
                doorstatus = "关";
            } else {
                doorstatus = "开";
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
            item.put("guizi/liantiji", guizi + liantiji); //柜子/连体机
            item.put("version", IntegratedMachineController.transformVM(pkgname) + "/" + apkversionStr); //版本
            item.put("today", prices + "/" + count1); //今日(金额/次数)
            item.put("doorstatus", doorstatus); //门状态 0:门关闭着;1:门开着的
            item.put("number", number); //一元五角个数
            item.put("tempnow", lefttempnow + "/" + righttempnow); // 左温度/右温度
            item.put("tempstatus", tempstatus + "/" + insidetempnow + "/" + insidetempset); // 温度模式/室内温度/设置温度
            item.put("tracknum", tracknum + ""); //轨道数
            item.put("guzhangguidaoNum", guzhangguidaoNum + ""); //故障轨道
            item.put("quehuoguidaoNum", quehuoguidaoNum + ""); //缺货轨道
            item.put("kucunNum", kucunNum + ""); //库存(故障)


            list.add(item);

        }
        renderJson(list);


    }
}
