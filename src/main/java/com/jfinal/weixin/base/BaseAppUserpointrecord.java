package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAppUserpointrecord<M extends BaseAppUserpointrecord<M>> extends Model<M> implements IBean {

	public void setPointrecordid(java.math.BigInteger pointrecordid) {
		set("pointrecordid", pointrecordid);
	}

	public java.math.BigInteger getPointrecordid() {
		return get("pointrecordid");
	}

	public void setUserid(java.lang.Long userid) {
		set("userid", userid);
	}

	public java.lang.Long getUserid() {
		return get("userid");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setConnectid(java.lang.Long connectid) {
		set("connectid", connectid);
	}

	public java.lang.Long getConnectid() {
		return get("connectid");
	}

	public void setInserttime(java.util.Date inserttime) {
		set("inserttime", inserttime);
	}

	public java.util.Date getInserttime() {
		return get("inserttime");
	}

	public void setChangepoint(java.lang.Integer changepoint) {
		set("changepoint", changepoint);
	}

	public java.lang.Integer getChangepoint() {
		return get("changepoint");
	}

	public void setBeforepoint(java.lang.Integer beforepoint) {
		set("beforepoint", beforepoint);
	}

	public java.lang.Integer getBeforepoint() {
		return get("beforepoint");
	}

	public void setAfterpoint(java.lang.Integer afterpoint) {
		set("afterpoint", afterpoint);
	}

	public java.lang.Integer getAfterpoint() {
		return get("afterpoint");
	}

}
