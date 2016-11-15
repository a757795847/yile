package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseIdVmcards<M extends BaseIdVmcards<M>> extends Model<M> implements IBean {

	public void setCardid(java.lang.Long cardid) {
		set("cardid", cardid);
	}

	public java.lang.Long getCardid() {
		return get("cardid");
	}

	public void setAddrealname(java.lang.String addrealname) {
		set("addrealname", addrealname);
	}

	public java.lang.String getAddrealname() {
		return get("addrealname");
	}

	public void setAddtime(java.util.Date addtime) {
		set("addtime", addtime);
	}

	public java.util.Date getAddtime() {
		return get("addtime");
	}

	public void setCardbalance(java.lang.Double cardbalance) {
		set("cardbalance", cardbalance);
	}

	public java.lang.Double getCardbalance() {
		return get("cardbalance");
	}

	public void setCardnum(java.lang.String cardnum) {
		set("cardnum", cardnum);
	}

	public java.lang.String getCardnum() {
		return get("cardnum");
	}

	public void setPassword(java.lang.String password) {
		set("password", password);
	}

	public java.lang.String getPassword() {
		return get("password");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public void setUnitid(java.lang.Long unitid) {
		set("unitid", unitid);
	}

	public java.lang.Long getUnitid() {
		return get("unitid");
	}

	public void setUsername(java.lang.String username) {
		set("username", username);
	}

	public java.lang.String getUsername() {
		return get("username");
	}

	public void setVmcustomerid(java.lang.Long vmcustomerid) {
		set("vmcustomerid", vmcustomerid);
	}

	public java.lang.Long getVmcustomerid() {
		return get("vmcustomerid");
	}

	public void setEffectivedate(java.util.Date effectivedate) {
		set("effectivedate", effectivedate);
	}

	public java.util.Date getEffectivedate() {
		return get("effectivedate");
	}

	public void setMobilephone(java.lang.String mobilephone) {
		set("mobilephone", mobilephone);
	}

	public java.lang.String getMobilephone() {
		return get("mobilephone");
	}

	public void setSex(java.lang.String sex) {
		set("sex", sex);
	}

	public java.lang.String getSex() {
		return get("sex");
	}

	public void setRemarks(java.lang.String remarks) {
		set("remarks", remarks);
	}

	public java.lang.String getRemarks() {
		return get("remarks");
	}

	public void setBirthday(java.lang.String birthday) {
		set("birthday", birthday);
	}

	public java.lang.String getBirthday() {
		return get("birthday");
	}

}
