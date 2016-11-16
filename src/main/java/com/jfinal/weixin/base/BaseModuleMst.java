package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseModuleMst<M extends BaseModuleMst<M>> extends Model<M> implements IBean {

	public void setIdModule(java.math.BigInteger idModule) {
		set("id_module", idModule);
	}

	public java.math.BigInteger getIdModule() {
		return get("id_module");
	}

	public void setSubSysType(java.lang.Integer subSysType) {
		set("sub_sys_type", subSysType);
	}

	public java.lang.Integer getSubSysType() {
		return get("sub_sys_type");
	}

	public void setSubSysName(java.lang.String subSysName) {
		set("sub_sys_name", subSysName);
	}

	public java.lang.String getSubSysName() {
		return get("sub_sys_name");
	}

	public void setModuleCode(java.lang.String moduleCode) {
		set("module_code", moduleCode);
	}

	public java.lang.String getModuleCode() {
		return get("module_code");
	}

	public void setModuleName(java.lang.String moduleName) {
		set("module_name", moduleName);
	}

	public java.lang.String getModuleName() {
		return get("module_name");
	}

	public void setFlgDeleted(java.lang.Integer flgDeleted) {
		set("flg_deleted", flgDeleted);
	}

	public java.lang.Integer getFlgDeleted() {
		return get("flg_deleted");
	}

	public void setIdCrtUser(java.math.BigInteger idCrtUser) {
		set("id_crt_user", idCrtUser);
	}

	public java.math.BigInteger getIdCrtUser() {
		return get("id_crt_user");
	}

	public void setTimeCrt(java.util.Date timeCrt) {
		set("time_crt", timeCrt);
	}

	public java.util.Date getTimeCrt() {
		return get("time_crt");
	}

	public void setIdUpdUser(java.math.BigInteger idUpdUser) {
		set("id_upd_user", idUpdUser);
	}

	public java.math.BigInteger getIdUpdUser() {
		return get("id_upd_user");
	}

	public void setTimeUpd(java.util.Date timeUpd) {
		set("time_upd", timeUpd);
	}

	public java.util.Date getTimeUpd() {
		return get("time_upd");
	}

}