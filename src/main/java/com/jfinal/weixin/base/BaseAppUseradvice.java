package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAppUseradvice<M extends BaseAppUseradvice<M>> extends Model<M> implements IBean {

	public void setId(java.math.BigInteger id) {
		set("id", id);
	}

	public java.math.BigInteger getId() {
		return get("id");
	}

	public void setUserid(java.lang.Long userid) {
		set("userid", userid);
	}

	public java.lang.Long getUserid() {
		return get("userid");
	}

	public void setAdvicetime(java.util.Date advicetime) {
		set("advicetime", advicetime);
	}

	public java.util.Date getAdvicetime() {
		return get("advicetime");
	}

	public void setAdvicetext(java.lang.String advicetext) {
		set("advicetext", advicetext);
	}

	public java.lang.String getAdvicetext() {
		return get("advicetext");
	}

	public void setBackmail(java.lang.String backmail) {
		set("backmail", backmail);
	}

	public java.lang.String getBackmail() {
		return get("backmail");
	}

	public void setBacktext(java.lang.String backtext) {
		set("backtext", backtext);
	}

	public java.lang.String getBacktext() {
		return get("backtext");
	}

	public void setBacktime(java.util.Date backtime) {
		set("backtime", backtime);
	}

	public java.util.Date getBacktime() {
		return get("backtime");
	}

	public void setOperatename(java.lang.String operatename) {
		set("operatename", operatename);
	}

	public java.lang.String getOperatename() {
		return get("operatename");
	}

}
