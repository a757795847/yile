package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxOwnerinfo<M extends BaseWxOwnerinfo<M>> extends Model<M> implements IBean {

	public void setOwneropenid(java.lang.String owneropenid) {
		set("owneropenid", owneropenid);
	}

	public java.lang.String getOwneropenid() {
		return get("owneropenid");
	}

	public void setOwnername(java.lang.String ownername) {
		set("ownername", ownername);
	}

	public java.lang.String getOwnername() {
		return get("ownername");
	}

	public void setEventkey(java.lang.String eventkey) {
		set("eventkey", eventkey);
	}

	public java.lang.String getEventkey() {
		return get("eventkey");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public void setUpdateusername(java.lang.String updateusername) {
		set("updateusername", updateusername);
	}

	public java.lang.String getUpdateusername() {
		return get("updateusername");
	}

	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}

	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

}
