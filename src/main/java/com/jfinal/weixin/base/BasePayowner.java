package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePayowner<M extends BasePayowner<M>> extends Model<M> implements IBean {

	public void setOwner(java.lang.String owner) {
		set("owner", owner);
	}

	public java.lang.String getOwner() {
		return get("owner");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

}
