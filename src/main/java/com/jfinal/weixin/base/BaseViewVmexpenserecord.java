package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseViewVmexpenserecord<M extends BaseViewVmexpenserecord<M>> extends Model<M> implements IBean {

	public void setCardsid(java.lang.Long cardsid) {
		set("cardsid", cardsid);
	}

	public java.lang.Long getCardsid() {
		return get("cardsid");
	}

	public void setSum(java.lang.Double sum) {
		set("sum", sum);
	}

	public java.lang.Double getSum() {
		return get("sum");
	}

}