package com.jfinal.weixin.controller;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zengriyong on 16/11/21.
 */
public class IntegratedMachineController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        String sql = "SELECT\n" +
                "concat(\n" +
                "\t\tDATE_FORMAT(\n" +
                "\t\t\tandroidvmuserinfo.registdate ,\n" +
                "\t\t\t'%Y%c%d'\n" +
                "\t\t) ,\n" +
                "\t\tandroidvmuserinfo.deviceid\n" +
                "\t) AS rd,\n" +
                "\tsum(androidsalelist.price) prices,\n" +
                "\tcount(androidsalelist.yyyymmdd) count1 ,\n" +
                "\tandroidsetpara.*, \n" +
                "\tandroidnetinfo.lastnettime ,\n" +
                "\tandroidtrackka.*, \n" +
                "\tandroidnetappstart.pkgname ,\n" +
                "\tandroidnetappstart.apkversion ,\n" +
                "\tCOUNT(androidcabineta.deviceid) counta,\n" +
                "\tCOUNT(androidcabinetb.deviceid) countb,\n" +
                "\tCOUNT(androidcabinetc.deviceid) countc,\n" +
                "\tCOUNT(androidcabinetd.deviceid) countd,\n" +
                "\tCOUNT(androidcabinete.deviceid) counte,\n" +
                "\tCOUNT(androidtrackdouble.deviceid) count2\n" +
                "FROM\n" +
                "\tandroidsetpara\n" +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidsetpara.deviceid\n" +
                "AND androidvmuserinfo.vmcustomerid = ?\n" +
                "LEFT JOIN androidnetinfo ON androidnetinfo.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidtrackka ON androidtrackka.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidnetappstart ON androidnetappstart.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabineta ON androidcabineta.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinetb ON androidcabinetb.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinetc ON androidcabinetc.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinetd ON androidcabinetd.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinete ON androidcabinete.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidtrackdouble ON androidtrackdouble.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidsalelist ON androidsalelist.deviceid = androidsetpara.deviceid\n" +
                "AND androidsalelist.yyyymmdd = ?\n" +
                "where concat(\n" +
                "\t\tDATE_FORMAT(\n" +
                "\t\t\tandroidvmuserinfo.registdate ,\n" +
                "\t\t\t'%Y%c%d'\n" +
                "\t\t) ,\n" +
                "\t\tandroidvmuserinfo.deviceid\n" +
                "\t) < ?\n" +
                "GROUP BY\n" +
                "\tandroidsetpara.deviceid, androidsalelist.yyyymmdd\n" +
                "ORDER BY\n" +
                "\trd DESC" +
                "LIMIT ?";

        String sql1 = "SELECT\n" +
                "concat(\n" +
                "\t\tDATE_FORMAT(\n" +
                "\t\t\tandroidvmuserinfo.registdate ,\n" +
                "\t\t\t'%Y%c%d'\n" +
                "\t\t) ,\n" +
                "\t\tandroidvmuserinfo.deviceid\n" +
                "\t) AS rd,\n" +
                "\tsum(androidsalelist.price) prices,\n" +
                "\tcount(androidsalelist.yyyymmdd) count1 ,\n" +
                "\tandroidsetpara.*, \n" +
                "\tandroidnetinfo.lastnettime ,\n" +
                "\tandroidtrackka.*, \n" +
                "\tandroidnetappstart.pkgname ,\n" +
                "\tandroidnetappstart.apkversion ,\n" +
                "\tCOUNT(androidcabineta.deviceid) counta,\n" +
                "\tCOUNT(androidcabinetb.deviceid) countb,\n" +
                "\tCOUNT(androidcabinetc.deviceid) countc,\n" +
                "\tCOUNT(androidcabinetd.deviceid) countd,\n" +
                "\tCOUNT(androidcabinete.deviceid) counte,\n" +
                "\tCOUNT(androidtrackdouble.deviceid) count2\n" +
                "FROM\n" +
                "\tandroidsetpara\n" +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidsetpara.deviceid\n" +
                "AND androidvmuserinfo.vmcustomerid = ?\n" +
                "LEFT JOIN androidnetinfo ON androidnetinfo.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidtrackka ON androidtrackka.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidnetappstart ON androidnetappstart.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabineta ON androidcabineta.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinetb ON androidcabinetb.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinetc ON androidcabinetc.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinetd ON androidcabinetd.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidcabinete ON androidcabinete.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidtrackdouble ON androidtrackdouble.deviceid = androidsetpara.deviceid\n" +
                "LEFT JOIN androidsalelist ON androidsalelist.deviceid = androidsetpara.deviceid\n" +
                "AND androidsalelist.yyyymmdd = ?\n" +
                "GROUP BY\n" +
                "\tandroidsetpara.deviceid, androidsalelist.yyyymmdd\n" +
                "ORDER BY\n" +
                "\trd DESC\n" +
                "LIMIT ?";

        String today = DateTime.now().toString("yyyy-MM-dd");
        Vmmisuser vmmisuser = getSessionAttr("vmmisuser");
        System.out.println("vmmisuser: " + vmmisuser);
        String rd = getPara("rd");
        System.out.println("rd: " + rd);
        List<Record> data;
        if(StrKit.notBlank(rd)){
            System.out.println("11111111111111111");
            data = Db.find(sql, vmmisuser.getVmcustomerid(), today, rd , 20);
        }else{
            System.out.println("22222222222222222");
            data = Db.find(sql1, vmmisuser.getVmcustomerid(), today, 20);
        }

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int n = 0; n < data.size(); n++) {
            String deviceid = data.get(n).get("deviceid").toString();
            String vmname = data.get(n).get("vmname").toString();
            String lastnettime = data.get(n).get("lastnettime").toString();

            String coinstatus = data.get(n).get("coinstatus").toString();
            String coinoutstatus = data.get(n).get("coinoutstatus").toString();
            String billstatus = data.get(n).get("billstatus").toString();
            String coin1yuan = data.get(n).get("coin1yuan").toString();
            String coin5jiao = data.get(n).get("coin5jiao").toString();

            if (StrKit.isBlank(coin1yuan)) {
                coin1yuan = "0";
            }
            if (StrKit.isBlank(coin5jiao)) {
                coin5jiao = "0";
            }


            String trackfloor = data.get(n).get("trackfloor").toString();
            String prices = "";
            if (data.get(n).get("prices") != null) {
                prices = data.get(n).get("prices").toString();
            }

            String count1 = data.get(n).get("count1").toString();
            String pkgname = data.get(n).get("pkgname").toString();
            String apkversion = data.get(n).get("apkversion").toString();
            Long counta = data.get(n).get("counta");
            Long countb = data.get(n).get("countb");
            Long countc = data.get(n).get("countc");
            Long countd = data.get(n).get("countd");
            Long counte = data.get(n).get("counte");
            Long count2 = data.get(n).get("count2");

            Set<String> youxiaoguidao = new HashSet<String>();
            if (StrKit.notBlank(trackfloor)) {
                int z = 0;
                int num = 0;
                for (int i = 1; i <= 7; i++) {
                    z = i - 1;
                    num = data.get(n).get("everyfloortracknum" + i);
                    for (int y = num - 1; y >= 0; y--) {
                        youxiaoguidao.add(z + "" + y);
                    }
                }
            }

            int guzhangguidaoNum = 0;
            int quehuoguidaoNum = 0;
            int kucunNum = 0;
            for (String it : youxiaoguidao) {
                String i = data.get(n).get("trackstatus" + it).toString();

                int now = data.get(n).get("numnow" + it);
                int max = data.get(n).get("nummax" + it);
                kucunNum += now;

                if ("0".equals(i)) {
                    guzhangguidaoNum++;
                } else if ("1".equals(i) && now < max) {
                    quehuoguidaoNum++;
                }
            }

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
            HashMap<String, String> item1 = new HashMap<String, String>();
            HashMap<String, String> item2 = new HashMap<String, String>();
            HashMap<String, String> item3 = new HashMap<String, String>();
            HashMap<String, String> item4 = new HashMap<String, String>();
            item.put("deviceid", data.get(n).get("deviceid").toString()); //设备id
            item.put("vmname", data.get(n).get("vmname").toString()); //机器名称
            item.put("lastnettime", data.get(n).get("lastnettime").toString()); //联网状态
            item.put("billstatus", billstatus); //纸币
            item.put("coinstatus", coinstatus); //硬币找零
            item.put("coin1yuan", coin1yuan); //钱箱(1元)
            item.put("coin5jiao", coin5jiao); //钱箱(五角)
            item.put("guzhangguidaoNum", guzhangguidaoNum + ""); //故障轨道
            item.put("quehuoguidaoNum", quehuoguidaoNum + ""); //缺货轨道
            item.put("kucunNum", kucunNum + ""); //库存(故障)
            item.put("today", prices + "/" + count1); //今日(金额/次数)
            item.put("version", transformVM(pkgname) + "/" + apkversionStr); //版本
            item.put("guizi/liantiji", guizi + liantiji); //柜子/连体机

            item1.put("deviceid", data.get(n).get("deviceid").toString()); //设备id
            item1.put("vmname", data.get(n).get("vmname").toString()); //机器名称
            item1.put("lastnettime", data.get(n).get("lastnettime").toString()); //联网状态
            item1.put("billstatus", billstatus); //纸币
            item1.put("coinstatus", coinstatus); //硬币找零
            item1.put("coin1yuan", coin1yuan); //钱箱(1元)
            item1.put("coin5jiao", coin5jiao); //钱箱(五角)
            item1.put("guzhangguidaoNum", guzhangguidaoNum + ""); //故障轨道
            item1.put("quehuoguidaoNum", quehuoguidaoNum + ""); //缺货轨道
            item1.put("kucunNum", kucunNum + ""); //库存(故障)
            item1.put("today", prices + "/" + count1); //今日(金额/次数)
            item1.put("version", transformVM(pkgname) + "/" + apkversionStr); //版本
            item1.put("guizi/liantiji", guizi + liantiji); //柜子/连体机

            item2.put("deviceid", data.get(n).get("deviceid").toString()); //设备id
            item2.put("vmname", data.get(n).get("vmname").toString()); //机器名称
            item2.put("lastnettime", data.get(n).get("lastnettime").toString()); //联网状态
            item2.put("billstatus", billstatus); //纸币
            item2.put("coinstatus", coinstatus); //硬币找零
            item2.put("coin1yuan", coin1yuan); //钱箱(1元)
            item2.put("coin5jiao", coin5jiao); //钱箱(五角)
            item2.put("guzhangguidaoNum", guzhangguidaoNum + ""); //故障轨道
            item2.put("quehuoguidaoNum", quehuoguidaoNum + ""); //缺货轨道
            item2.put("kucunNum", kucunNum + ""); //库存(故障)
            item2.put("today", prices + "/" + count1); //今日(金额/次数)
            item2.put("version", transformVM(pkgname) + "/" + apkversionStr); //版本
            item2.put("guizi/liantiji", guizi + liantiji); //柜子/连体机

            item3.put("deviceid", data.get(n).get("deviceid").toString()); //设备id
            item3.put("vmname", data.get(n).get("vmname").toString()); //机器名称
            item3.put("lastnettime", data.get(n).get("lastnettime").toString()); //联网状态
            item3.put("billstatus", billstatus); //纸币
            item3.put("coinstatus", coinstatus); //硬币找零
            item3.put("coin1yuan", coin1yuan); //钱箱(1元)
            item3.put("coin5jiao", coin5jiao); //钱箱(五角)
            item3.put("guzhangguidaoNum", guzhangguidaoNum + ""); //故障轨道
            item3.put("quehuoguidaoNum", quehuoguidaoNum + ""); //缺货轨道
            item3.put("kucunNum", kucunNum + ""); //库存(故障)
            item3.put("today", prices + "/" + count1); //今日(金额/次数)
            item3.put("version", transformVM(pkgname) + "/" + apkversionStr); //版本
            item3.put("guizi/liantiji", guizi + liantiji); //柜子/连体机

            item4.put("deviceid", data.get(n).get("deviceid").toString()); //设备id
            item4.put("vmname", data.get(n).get("vmname").toString()); //机器名称
            item4.put("lastnettime", data.get(n).get("lastnettime").toString()); //联网状态
            item4.put("billstatus", billstatus); //纸币
            item4.put("coinstatus", coinstatus); //硬币找零
            item4.put("coin1yuan", coin1yuan); //钱箱(1元)
            item4.put("coin5jiao", coin5jiao); //钱箱(五角)
            item4.put("guzhangguidaoNum", guzhangguidaoNum + ""); //故障轨道
            item4.put("quehuoguidaoNum", quehuoguidaoNum + ""); //缺货轨道
            item4.put("kucunNum", kucunNum + ""); //库存(故障)
            item4.put("today", prices + "/" + count1); //今日(金额/次数)
            item4.put("version", transformVM(pkgname) + "/" + apkversionStr); //版本
            item4.put("guizi/liantiji", guizi + liantiji); //柜子/连体机

            list.add(item);
            list.add(item1);
            list.add(item2);
            list.add(item3);
            list.add(item4);
        }
        renderJson(list);
    }

    public String transformVM(String str) {
        String myversion = "";
        if ("VMSelf206".equals(str)) {
            myversion = "饮料206";
        } else if ("VMAVSelf".equals(str)) {
            myversion = "成人7寸";
        } else if ("vmselfav".equals(str)) {
            myversion = "成人7寸";
        } else if ("VMAVHDSelf".equals(str)) {
            myversion = "成人32寸";
        } else if ("vmguangone".equals(str)) {
            myversion = "光脚一号";
        } else if ("VMHDSelf".equals(str)) {
            myversion = "大屏综合";
        } else if ("vmcoffee308c".equals(str)) {
            myversion = "308-C咖啡机";
        } else if ("vmcoffee308b".equals(str)) {
            myversion = "308-B咖啡机";
        } else if ("vmcoffee307".equals(str)) {
            myversion = "307咖啡机";
        } else {
            myversion = "7寸综合";
        }
        return myversion;
    }
}
