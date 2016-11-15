package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAppUserpayback<M extends BaseAppUserpayback<M>> extends Model<M> implements IBean {

	public void setPaybackid(java.math.BigInteger paybackid) {
		set("paybackid", paybackid);
	}

	public java.math.BigInteger getPaybackid() {
		return get("paybackid");
	}

	public void setUserid(java.lang.Long userid) {
		set("userid", userid);
	}

	public java.lang.Long getUserid() {
		return get("userid");
	}

	public void setRequestdate(java.util.Date requestdate) {
		set("requestdate", requestdate);
	}

	public java.util.Date getRequestdate() {
		return get("requestdate");
	}

	public void setRequesttime(java.util.Date requesttime) {
		set("requesttime", requesttime);
	}

	public java.util.Date getRequesttime() {
		return get("requesttime");
	}

	public void setPaybackway(java.lang.String paybackway) {
		set("paybackway", paybackway);
	}

	public java.lang.String getPaybackway() {
		return get("paybackway");
	}

	public void setPayerid(java.lang.String payerid) {
		set("payerid", payerid);
	}

	public java.lang.String getPayerid() {
		return get("payerid");
	}

	public void setPaybackmoney(java.math.BigDecimal paybackmoney) {
		set("paybackmoney", paybackmoney);
	}

	public java.math.BigDecimal getPaybackmoney() {
		return get("paybackmoney");
	}

	public void setPaybackstatus(java.lang.String paybackstatus) {
		set("paybackstatus", paybackstatus);
	}

	public java.lang.String getPaybackstatus() {
		return get("paybackstatus");
	}

	public void setOperatename(java.lang.String operatename) {
		set("operatename", operatename);
	}

	public java.lang.String getOperatename() {
		return get("operatename");
	}

	public void setOperatetime(java.util.Date operatetime) {
		set("operatetime", operatetime);
	}

	public java.util.Date getOperatetime() {
		return get("operatetime");
	}

	public void setOutRefundNo(java.lang.String outRefundNo) {
		set("out_refund_no", outRefundNo);
	}

	public java.lang.String getOutRefundNo() {
		return get("out_refund_no");
	}

}
