package com.jfinal.weixin.controller;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
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
public class SaleDataController extends ApiController {

    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        String sql = "SELECT " +
                " concat( " +
                "  DATE_FORMAT( " +
                "   androidsalelist.saletime , " +
                "   '%Y%m%d%H%i%S' " +
                "  ) , " +
                "  androidsalelist.deviceid " +
                " ) AS rds , " +
                " DATE_FORMAT(androidsalelist.saletime, '%Y-%m-%d %H:%i:%S') stime, " +
                " androidsalelist.* " +
                "FROM " +
                " androidsalelist " +
                "where androidsalelist.deviceid = ? " +
                "ORDER BY rd  " +
                "LIMIT ?";

        String sql1 = "SELECT " +
                " concat( " +
                "  DATE_FORMAT( " +
                "   androidsalelist.saletime , " +
                "   '%Y%m%d%H%i%S' " +
                "  ) , " +
                "  androidsalelist.deviceid " +
                " ) AS rds , " +
                " DATE_FORMAT(androidsalelist.saletime, '%Y-%m-%d %H:%i:%S') stime, " +
                " androidsalelist.* " +
                "FROM " +
                " androidsalelist " +
                "where androidsalelist.deviceid = ? " +
                " and concat( " +
                "  DATE_FORMAT( " +
                "   androidsalelist.saletime , " +
                "   '%Y%m%d%H%i%S' " +
                "  ) , " +
                "  androidsalelist.deviceid " +
                " ) < ? " +
                "ORDER BY rd  " +
                "LIMIT ?";

        List<Record> data;
        String did = getPara("did");
        String rd = getPara("rd");
        String rows = getPara("rows");
        System.out.println("rd: " + rd + ", did: " + did + ", rows: " + rows);
        if (StrKit.notBlank(rd) && StrKit.notBlank(rows)) {

            data = Db.find(sql1, did, rd, rows);

        } else if (StrKit.isBlank(rd) && StrKit.notBlank(rows)) {

            data = Db.find(sql, did, rows);

        } else if (StrKit.notBlank(rd) && StrKit.isBlank(rows)) {

            data = Db.find(sql1, did, rd, 30);
        } else {

            data = Db.find(sql, did, 30);
        }

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int n = 0; n < data.size(); n++) {
            String deviceid = data.get(n).get("deviceid").toString();
            String saletime = data.get(n).get("stime").toString();
            String outtype = data.get(n).get("outtype").toString();
            String trackno = data.get(n).get("trackno").toString();
            String mingcheng = data.get(n).get("mingcheng").toString();
            String buyprice = data.get(n).get("buyprice").toString();
            String price = data.get(n).get("price").toString();
            String payway = data.get(n).get("payway").toString();
            String tranid = data.get(n).get("tranid").toString();
            String rds = data.get(n).get("rds").toString();

            String way = "";
            if ("现金".equals(payway)) {
                way = payway;
            } else {
                way = payway + ": " + tranid;
            }

            HashMap<String, String> item = new HashMap<String, String>();

            item.put("deviceid", deviceid);
            item.put("saletime", saletime);
            item.put("outtype", outtype);
            item.put("trackno", trackno);
            item.put("mingcheng", mingcheng);
            item.put("buyprice", buyprice);
            item.put("price", price);
            item.put("payway", way);
            item.put("rd", rds);


            list.add(item);

        }
        renderJson(list);
    }
}
