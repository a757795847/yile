package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGoodsname206<M extends BaseGoodsname206<M>> extends Model<M> implements IBean {

	public void setAutoid(java.lang.Long autoid) {
		set("autoid", autoid);
	}

	public java.lang.Long getAutoid() {
		return get("autoid");
	}

	public void setVmcustomerid(java.lang.Long vmcustomerid) {
		set("vmcustomerid", vmcustomerid);
	}

	public java.lang.Long getVmcustomerid() {
		return get("vmcustomerid");
	}

	public void setGoodsname(java.lang.String goodsname) {
		set("goodsname", goodsname);
	}

	public java.lang.String getGoodsname() {
		return get("goodsname");
	}

	public void setPicturename(java.lang.String picturename) {
		set("picturename", picturename);
	}

	public java.lang.String getPicturename() {
		return get("picturename");
	}

	public void setBuyprice(java.math.BigDecimal buyprice) {
		set("buyprice", buyprice);
	}

	public java.math.BigDecimal getBuyprice() {
		return get("buyprice");
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

	public void setIsactive(java.lang.String isactive) {
		set("isactive", isactive);
	}

	public java.lang.String getIsactive() {
		return get("isactive");
	}

}
