package com.jfinal.weixin.entity;

import com.jfinal.weixin.sdk.utils.JsonUtils;

/**
 * 
 * @author Javen
 * @Email javenlife@126.com
 * 公交线路
 */
public class GongjiaoLine {
	private String name;
	private String jiage;
	private String zhengxiang;
	private String fanxiang;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJiage() {
		return jiage;
	}

	public void setJiage(String jiage) {
		this.jiage = jiage;
	}

	public String getZhengxiang() {
		return zhengxiang;
	}

	public void setZhengxiang(String zhengxiang) {
		this.zhengxiang = zhengxiang;
	}

	public String getFanxiang() {
		return fanxiang;
	}

	public void setFanxiang(String fanxiang) {
		this.fanxiang = fanxiang;
	}

	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}