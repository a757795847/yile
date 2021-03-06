package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAndroidvmuserinfo<M extends BaseAndroidvmuserinfo<M>> extends Model<M> implements IBean {

	public void setDeviceid(java.lang.String deviceid) {
		set("deviceid", deviceid);
	}

	public java.lang.String getDeviceid() {
		return get("deviceid");
	}

	public void setModel(java.lang.String model) {
		set("model", model);
	}

	public java.lang.String getModel() {
		return get("model");
	}

	public void setVmcustomerid(java.math.BigInteger vmcustomerid) {
		set("vmcustomerid", vmcustomerid);
	}

	public java.math.BigInteger getVmcustomerid() {
		return get("vmcustomerid");
	}

	public void setRegistdate(java.util.Date registdate) {
		set("registdate", registdate);
	}

	public java.util.Date getRegistdate() {
		return get("registdate");
	}

	public void setRegistrealname(java.lang.String registrealname) {
		set("registrealname", registrealname);
	}

	public java.lang.String getRegistrealname() {
		return get("registrealname");
	}

	public void setMoneyyyyymm(java.lang.String moneyyyyymm) {
		set("moneyyyyymm", moneyyyyymm);
	}

	public java.lang.String getMoneyyyyymm() {
		return get("moneyyyyymm");
	}

	public void setDiscarddate(java.util.Date discarddate) {
		set("discarddate", discarddate);
	}

	public java.util.Date getDiscarddate() {
		return get("discarddate");
	}

	public void setDiscardreason(java.lang.String discardreason) {
		set("discardreason", discardreason);
	}

	public java.lang.String getDiscardreason() {
		return get("discardreason");
	}

	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}

	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

	public void setUpdaterealname(java.lang.String updaterealname) {
		set("updaterealname", updaterealname);
	}

	public java.lang.String getUpdaterealname() {
		return get("updaterealname");
	}

}
