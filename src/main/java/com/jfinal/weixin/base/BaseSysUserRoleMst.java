package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysUserRoleMst<M extends BaseSysUserRoleMst<M>> extends Model<M> implements IBean {

	public void setUserId(java.lang.String userId) {
		set("user_id", userId);
	}

	public java.lang.String getUserId() {
		return get("user_id");
	}

	public void setIdRole(java.math.BigInteger idRole) {
		set("id_role", idRole);
	}

	public java.math.BigInteger getIdRole() {
		return get("id_role");
	}

}
