package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseHzcityrecord<M extends BaseHzcityrecord<M>> extends Model<M> implements IBean {

	public void setIdstr(java.lang.String idstr) {
		set("idstr", idstr);
	}

	public java.lang.String getIdstr() {
		return get("idstr");
	}

	public void setAndroidid(java.lang.String androidid) {
		set("androidid", androidid);
	}

	public java.lang.String getAndroidid() {
		return get("androidid");
	}

	public void setCardserialno(java.lang.String cardserialno) {
		set("cardserialno", cardserialno);
	}

	public java.lang.String getCardserialno() {
		return get("cardserialno");
	}

	public void setMachinetime(java.util.Date machinetime) {
		set("machinetime", machinetime);
	}

	public java.util.Date getMachinetime() {
		return get("machinetime");
	}

	public void setInserttime(java.util.Date inserttime) {
		set("inserttime", inserttime);
	}

	public java.util.Date getInserttime() {
		return get("inserttime");
	}

	public void setPara(java.lang.String para) {
		set("para", para);
	}

	public java.lang.String getPara() {
		return get("para");
	}

}
