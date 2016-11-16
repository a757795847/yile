package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseIdVmunitoperator<M extends BaseIdVmunitoperator<M>> extends Model<M> implements IBean {

	public void setUnitoperatorid(java.lang.Long unitoperatorid) {
		set("unitoperatorid", unitoperatorid);
	}

	public java.lang.Long getUnitoperatorid() {
		return get("unitoperatorid");
	}

	public void setAddtime(java.util.Date addtime) {
		set("addtime", addtime);
	}

	public java.util.Date getAddtime() {
		return get("addtime");
	}

	public void setLoginname(java.lang.String loginname) {
		set("loginname", loginname);
	}

	public java.lang.String getLoginname() {
		return get("loginname");
	}

	public void setPagesize(java.lang.Integer pagesize) {
		set("pagesize", pagesize);
	}

	public java.lang.Integer getPagesize() {
		return get("pagesize");
	}

	public void setPassword(java.lang.String password) {
		set("password", password);
	}

	public java.lang.String getPassword() {
		return get("password");
	}

	public void setPhone(java.lang.String phone) {
		set("phone", phone);
	}

	public java.lang.String getPhone() {
		return get("phone");
	}

	public void setRealname(java.lang.String realname) {
		set("realname", realname);
	}

	public java.lang.String getRealname() {
		return get("realname");
	}

	public void setType(java.lang.Integer type) {
		set("type", type);
	}

	public java.lang.Integer getType() {
		return get("type");
	}

	public void setUnitid(java.lang.Long unitid) {
		set("unitid", unitid);
	}

	public java.lang.Long getUnitid() {
		return get("unitid");
	}

	public void setUpdaterealname(java.lang.String updaterealname) {
		set("updaterealname", updaterealname);
	}

	public java.lang.String getUpdaterealname() {
		return get("updaterealname");
	}

	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}

	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

	public void setVmcustomerid(java.lang.Long vmcustomerid) {
		set("vmcustomerid", vmcustomerid);
	}

	public java.lang.Long getVmcustomerid() {
		return get("vmcustomerid");
	}

}