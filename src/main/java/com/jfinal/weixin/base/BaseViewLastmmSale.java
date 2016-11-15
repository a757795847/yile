package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseViewLastmmSale<M extends BaseViewLastmmSale<M>> extends Model<M> implements IBean {

	public void setDeviceid(java.lang.String deviceid) {
		set("deviceid", deviceid);
	}

	public java.lang.String getDeviceid() {
		return get("deviceid");
	}

	public void setYyyymm(java.lang.String yyyymm) {
		set("yyyymm", yyyymm);
	}

	public java.lang.String getYyyymm() {
		return get("yyyymm");
	}

	public void setCount(java.lang.Long count) {
		set("count", count);
	}

	public java.lang.Long getCount() {
		return get("count");
	}

	public void setSum(java.math.BigDecimal sum) {
		set("sum", sum);
	}

	public java.math.BigDecimal getSum() {
		return get("sum");
	}

}
