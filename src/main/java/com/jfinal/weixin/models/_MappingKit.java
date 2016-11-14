package com.jfinal.weixin.models;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("ab_recv", "", AbRecv.class);
		arp.addMapping("ab_send", "id", AbSend.class);
		arp.addMapping("androidcabineta", "deviceid", Androidcabineta.class);
		arp.addMapping("androidcabinetb", "deviceid", Androidcabinetb.class);
		arp.addMapping("androidcabinetc", "deviceid", Androidcabinetc.class);
		arp.addMapping("androidcabinetd", "deviceid", Androidcabinetd.class);
		arp.addMapping("androidcabinete", "deviceid", Androidcabinete.class);
		arp.addMapping("androidcoffee", "deviceid", Androidcoffee.class);
		// Composite Primary Key order: deviceid,happentime
		arp.addMapping("androiderrorpwd_log", "deviceid,happentime", AndroiderrorpwdLog.class);
		arp.addMapping("androidguangone", "deviceid", Androidguangone.class);
		arp.addMapping("androidnetappstart", "deviceid", Androidnetappstart.class);
		// Composite Primary Key order: appstarttime,deviceid
		arp.addMapping("androidnetappstart_log", "appstarttime,deviceid", AndroidnetappstartLog.class);
		arp.addMapping("androidnetinfo", "deviceid", Androidnetinfo.class);
		arp.addMapping("androidroute", "id", Androidroute.class);
		// Composite Primary Key order: masterid,slaveid
		arp.addMapping("androidrouteplan", "masterid,slaveid", Androidrouteplan.class);
		// Composite Primary Key order: deviceid,saletime
		arp.addMapping("androidsalelist", "deviceid,saletime", Androidsalelist.class);
		// Composite Primary Key order: deviceid,saletime
		arp.addMapping("androidsalelist_history", "deviceid,saletime", AndroidsalelistHistory.class);
		arp.addMapping("androidsetpara", "deviceid", Androidsetpara.class);
		arp.addMapping("androidtrackdouble", "deviceid", Androidtrackdouble.class);
		arp.addMapping("androidtrackka", "deviceid", Androidtrackka.class);
		arp.addMapping("androidvmuserinfo", "deviceid", Androidvmuserinfo.class);
		arp.addMapping("app_coupon", "couponid", AppCoupon.class);
		arp.addMapping("app_goodsurl", "goodurlid", AppGoodsurl.class);
		// Composite Primary Key order: mobilepfname,version
		arp.addMapping("app_lastestversion", "mobilepfname,version", AppLastestversion.class);
		arp.addMapping("app_mobilechkcode", "id", AppMobilechkcode.class);
		arp.addMapping("app_operater", "id", AppOperater.class);
		arp.addMapping("app_pointexchange", "pointexid", AppPointexchange.class);
		arp.addMapping("app_pointruler", "items", AppPointruler.class);
		arp.addMapping("app_ppn", "ppnid", AppPpn.class);
		arp.addMapping("app_useradvice", "id", AppUseradvice.class);
		arp.addMapping("app_userbbs", "bbsid", AppUserbbs.class);
		arp.addMapping("app_userbuygoods", "buyorderid", AppUserbuygoods.class);
		// Composite Primary Key order: couponid,userid
		arp.addMapping("app_usercoupon", "couponid,userid", AppUsercoupon.class);
		arp.addMapping("app_userinfo", "userid", AppUserinfo.class);
		arp.addMapping("app_usermoneyrecord", "moneyrecordid", AppUsermoneyrecord.class);
		arp.addMapping("app_userpayback", "paybackid", AppUserpayback.class);
		arp.addMapping("app_userpayok", "payokid", AppUserpayok.class);
		arp.addMapping("app_userpointexrecord", "pointexrecordid", AppUserpointexrecord.class);
		arp.addMapping("app_userpointrecord", "pointrecordid", AppUserpointrecord.class);
		// Composite Primary Key order: ppnid,userid
		arp.addMapping("app_userppn", "ppnid,userid", AppUserppn.class);
		// Composite Primary Key order: ppnid,sharerouter,shareuserid,userid
		arp.addMapping("app_usershareppn", "ppnid,sharerouter,shareuserid,userid", AppUsershareppn.class);
		arp.addMapping("chenmonth", "id", Chenmonth.class);
		arp.addMapping("goodsname", "goodautoid", Goodsname.class);
		arp.addMapping("goodsname206", "autoid", Goodsname206.class);
		arp.addMapping("goodsnameav", "goodautoid", Goodsnameav.class);
		arp.addMapping("hzcityblack", "blackid", Hzcityblack.class);
		arp.addMapping("hzcityrecord", "idstr", Hzcityrecord.class);
		arp.addMapping("hzcityyyyymmdd", "yyyymmdd", Hzcityyyyymmdd.class);
		arp.addMapping("id_vmcards", "cardid", IdVmcards.class);
		arp.addMapping("id_vmexpenserecord", "expenserecordid", IdVmexpenserecord.class);
		arp.addMapping("id_vmoperatecard", "operateid", IdVmoperatecard.class);
		arp.addMapping("id_vmrechargecard", "rechargecardid", IdVmrechargecard.class);
		arp.addMapping("id_vmrechargeunit", "rechargeunitid", IdVmrechargeunit.class);
		arp.addMapping("id_vmunit", "unitid", IdVmunit.class);
		arp.addMapping("id_vmunitoperator", "unitoperatorid", IdVmunitoperator.class);
		arp.addMapping("id_vmunitrecord", "unitrecordid", IdVmunitrecord.class);
		// Composite Primary Key order: apkname,apkversion
		arp.addMapping("latestappversion", "apkname,apkversion", Latestappversion.class);
		arp.addMapping("module_mst", "id_module", ModuleMst.class);
		// Composite Primary Key order: payway,tranid
		arp.addMapping("payok", "payway,tranid", Payok.class);
		// Composite Primary Key order: payway,tranid
		arp.addMapping("payok_history", "payway,tranid", PayokHistory.class);
		arp.addMapping("payowner", "owner", Payowner.class);
		arp.addMapping("role_mst", "id_role", RoleMst.class);
		// Composite Primary Key order: id_module,id_role
		arp.addMapping("role_perm_mst", "id_module,id_role", RolePermMst.class);
		arp.addMapping("sale_lastmm", "deviceid", SaleLastmm.class);
		arp.addMapping("sale_nowmm", "deviceid", SaleNowmm.class);
		arp.addMapping("sale_yesterday", "deviceid", SaleYesterday.class);
		// Composite Primary Key order: deviceid,inserttime
		arp.addMapping("supply206", "deviceid,inserttime", Supply206.class);
		// Composite Primary Key order: id_role,user_id
		arp.addMapping("sys_user_role_mst", "id_role,user_id", SysUserRoleMst.class);
		arp.addMapping("vmcustomerinfo", "id", Vmcustomerinfo.class);
		// Composite Primary Key order: masterid,slaveid
		arp.addMapping("vmcustomerproxy", "masterid,slaveid", Vmcustomerproxy.class);
		arp.addMapping("vmmisuser", "userid", Vmmisuser.class);
		arp.addMapping("vmmisuser_log", "logid", VmmisuserLog.class);
		arp.addMapping("vmmisuserpara", "userid", Vmmisuserpara.class);
		// Composite Primary Key order: fanopenid,owneropenid
		arp.addMapping("wx_faninfo", "fanopenid,owneropenid", WxFaninfo.class);
		arp.addMapping("wx_ownerinfo", "owneropenid", WxOwnerinfo.class);
		arp.addMapping("wxid_charge_cardno", "chargeid", WxidChargeCardno.class);
		arp.addMapping("wxid_openid_cardno", "fanopenid", WxidOpenidCardno.class);
		arp.addMapping("wxid_stock", "deviceid", WxidStock.class);
		arp.addMapping("wxid_vmid_wxopenid", "vmcustomerid", WxidVmidWxopenid.class);
		arp.addMapping("view_androidnetappstart_log_last", "", ViewAndroidnetappstartLogLast.class);
		arp.addMapping("view_androidnetappstart_log_last_info", "", ViewAndroidnetappstartLogLastInfo.class);
		arp.addMapping("view_lastmm_sale", "", ViewLastmmSale.class);
		arp.addMapping("view_nowmm_sale", "", ViewNowmmSale.class);
		arp.addMapping("view_today_sale", "", ViewTodaySale.class);
		arp.addMapping("view_vmexpenserecord", "", ViewVmexpenserecord.class);
		arp.addMapping("view_yesterday_sale", "", ViewYesterdaySale.class);
		arp.addMapping("view_yyyymm_sale", "", ViewYyyymmSale.class);
		arp.addMapping("view_yyyymmdd_sale", "", ViewYyyymmddSale.class);
	}
}

