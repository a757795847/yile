package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseVmmisuser<M extends BaseVmmisuser<M>> extends Model<M> implements IBean {

	public void setUserid(java.math.BigInteger userid) {
		set("userid", userid);
	}

	public java.math.BigInteger getUserid() {
		return get("userid");
	}

	public void setLoginname(java.lang.String loginname) {
		set("loginname", loginname);
	}

	public java.lang.String getLoginname() {
		return get("loginname");
	}

	public void setPassword(java.lang.String password) {
		set("password", password);
	}

	public java.lang.String getPassword() {
		return get("password");
	}

	public void setRealname(java.lang.String realname) {
		set("realname", realname);
	}

	public java.lang.String getRealname() {
		return get("realname");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public void setPwderrorcount(java.lang.Integer pwderrorcount) {
		set("pwderrorcount", pwderrorcount);
	}

	public java.lang.Integer getPwderrorcount() {
		return get("pwderrorcount");
	}

	public void setAuthority(java.lang.Integer authority) {
		set("authority", authority);
	}

	public java.lang.Integer getAuthority() {
		return get("authority");
	}

	public void setVmcustomerid(java.math.BigInteger vmcustomerid) {
		set("vmcustomerid", vmcustomerid);
	}

	public java.math.BigInteger getVmcustomerid() {
		return get("vmcustomerid");
	}

	public void setLastoklogintime(java.util.Date lastoklogintime) {
		set("lastoklogintime", lastoklogintime);
	}

	public java.util.Date getLastoklogintime() {
		return get("lastoklogintime");
	}

	public void setAddtime(java.util.Date addtime) {
		set("addtime", addtime);
	}

	public java.util.Date getAddtime() {
		return get("addtime");
	}

	public void setAddrealname(java.lang.String addrealname) {
		set("addrealname", addrealname);
	}

	public java.lang.String getAddrealname() {
		return get("addrealname");
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

	public void setFanopenid(java.lang.String fanopenid) {
		set("fanopenid", fanopenid);
	}

	public java.lang.String getFanopenid() {
		return get("fanopenid");
	}

}
