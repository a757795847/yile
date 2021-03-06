package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAppCoupon<M extends BaseAppCoupon<M>> extends Model<M> implements IBean {

	public void setCouponid(java.math.BigInteger couponid) {
		set("couponid", couponid);
	}

	public java.math.BigInteger getCouponid() {
		return get("couponid");
	}

	public void setCouponname(java.lang.String couponname) {
		set("couponname", couponname);
	}

	public java.lang.String getCouponname() {
		return get("couponname");
	}

	public void setCouponjpg(java.lang.String couponjpg) {
		set("couponjpg", couponjpg);
	}

	public java.lang.String getCouponjpg() {
		return get("couponjpg");
	}

	public void setStartdate(java.util.Date startdate) {
		set("startdate", startdate);
	}

	public java.util.Date getStartdate() {
		return get("startdate");
	}

	public void setEnddate(java.util.Date enddate) {
		set("enddate", enddate);
	}

	public java.util.Date getEnddate() {
		return get("enddate");
	}

	public void setCouponmoney(java.math.BigDecimal couponmoney) {
		set("couponmoney", couponmoney);
	}

	public java.math.BigDecimal getCouponmoney() {
		return get("couponmoney");
	}

	public void setComment(java.lang.String comment) {
		set("comment", comment);
	}

	public java.lang.String getComment() {
		return get("comment");
	}

}
