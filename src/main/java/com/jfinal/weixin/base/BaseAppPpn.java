package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAppPpn<M extends BaseAppPpn<M>> extends Model<M> implements IBean {

	public void setPpnid(java.math.BigInteger ppnid) {
		set("ppnid", ppnid);
	}

	public java.math.BigInteger getPpnid() {
		return get("ppnid");
	}

	public void setInserttime(java.util.Date inserttime) {
		set("inserttime", inserttime);
	}

	public java.util.Date getInserttime() {
		return get("inserttime");
	}

	public void setPpntitle(java.lang.String ppntitle) {
		set("ppntitle", ppntitle);
	}

	public java.lang.String getPpntitle() {
		return get("ppntitle");
	}

	public void setPpnphotourl(java.lang.String ppnphotourl) {
		set("ppnphotourl", ppnphotourl);
	}

	public java.lang.String getPpnphotourl() {
		return get("ppnphotourl");
	}

	public void setPpntotalurl(java.lang.String ppntotalurl) {
		set("ppntotalurl", ppntotalurl);
	}

	public java.lang.String getPpntotalurl() {
		return get("ppntotalurl");
	}

	public void setPpnshareurl(java.lang.String ppnshareurl) {
		set("ppnshareurl", ppnshareurl);
	}

	public java.lang.String getPpnshareurl() {
		return get("ppnshareurl");
	}

	public void setFirstreadgetpoint(java.lang.Integer firstreadgetpoint) {
		set("firstreadgetpoint", firstreadgetpoint);
	}

	public java.lang.Integer getFirstreadgetpoint() {
		return get("firstreadgetpoint");
	}

	public void setIsopen(java.lang.Integer isopen) {
		set("isopen", isopen);
	}

	public java.lang.Integer getIsopen() {
		return get("isopen");
	}

	public void setNewuserneedflag(java.lang.Integer newuserneedflag) {
		set("newuserneedflag", newuserneedflag);
	}

	public java.lang.Integer getNewuserneedflag() {
		return get("newuserneedflag");
	}

}
