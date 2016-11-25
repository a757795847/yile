package com.jfinal.weixin.controller;

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
public class SaleListController extends ApiController {

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
                " ) AS rd , " +
                " DATE_FORMAT(androidsalelist.saletime, '%Y-%m-%d %H:%i:%S') stime, " +
                " androidsalelist.* " +
                "FROM " +
                " androidsalelist " +
                "INNER JOIN androidvmuserinfo ON androidvmuserinfo.deviceid = androidsalelist.deviceid " +
                "AND androidvmuserinfo.vmcustomerid = ? " +
                "ORDER BY rd  " +
                "LIMIT ?";

        List<Record> data;
        data = Db.find(sql, 1, 30);

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

            String way = "";
            if("现金".equals(payway)){
                way = payway;
            }else{
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


            list.add(item);

        }
        renderJson(list);
    }
}
