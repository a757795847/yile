package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAndroiderrorpwdLog<M extends BaseAndroiderrorpwdLog<M>> extends Model<M> implements IBean {

	public void setDeviceid(java.lang.String deviceid) {
		set("deviceid", deviceid);
	}

	public java.lang.String getDeviceid() {
		return get("deviceid");
	}

	public void setHappentime(java.util.Date happentime) {
		set("happentime", happentime);
	}

	public java.util.Date getHappentime() {
		return get("happentime");
	}

	public void setErrorpwd(java.lang.String errorpwd) {
		set("errorpwd", errorpwd);
	}

	public java.lang.String getErrorpwd() {
		return get("errorpwd");
	}

	public void setIpaddress(java.lang.String ipaddress) {
		set("ipaddress", ipaddress);
	}

	public java.lang.String getIpaddress() {
		return get("ipaddress");
	}

}
