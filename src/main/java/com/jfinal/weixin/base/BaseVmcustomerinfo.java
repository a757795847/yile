package com.jfinal.weixin.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseVmcustomerinfo<M extends BaseVmcustomerinfo<M>> extends Model<M> implements IBean {

	public void setId(java.math.BigInteger id) {
		set("id", id);
	}

	public java.math.BigInteger getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setSname(java.lang.String sname) {
		set("sname", sname);
	}

	public java.lang.String getSname() {
		return get("sname");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public void setProxy(java.lang.Integer proxy) {
		set("proxy", proxy);
	}

	public java.lang.Integer getProxy() {
		return get("proxy");
	}

	public void setContact(java.lang.String contact) {
		set("contact", contact);
	}

	public java.lang.String getContact() {
		return get("contact");
	}

	public void setTelephone(java.lang.String telephone) {
		set("telephone", telephone);
	}

	public java.lang.String getTelephone() {
		return get("telephone");
	}

	public void setAddress(java.lang.String address) {
		set("address", address);
	}

	public java.lang.String getAddress() {
		return get("address");
	}

	public void setAddtime(java.util.Date addtime) {
		set("addtime", addtime);
	}

	public java.util.Date getAddtime() {
		return get("addtime");
	}

	public void setAddrealname(java.lang.String addrealname) {
		set("addrealname", addrealname);
	}

	public java.lang.String getAddrealname() {
		return get("addrealname");
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

	public void setAlipayPartner(java.lang.String alipayPartner) {
		set("alipay_partner", alipayPartner);
	}

	public java.lang.String getAlipayPartner() {
		return get("alipay_partner");
	}

	public void setAlipayKey(java.lang.String alipayKey) {
		set("alipay_key", alipayKey);
	}

	public java.lang.String getAlipayKey() {
		return get("alipay_key");
	}

	public void setAlipaySellerEmail(java.lang.String alipaySellerEmail) {
		set("alipay_seller_email", alipaySellerEmail);
	}

	public java.lang.String getAlipaySellerEmail() {
		return get("alipay_seller_email");
	}

	public void setAppId(java.lang.String appId) {
		set("app_id", appId);
	}

	public java.lang.String getAppId() {
		return get("app_id");
	}

	public void setPrivateKey(java.lang.String privateKey) {
		set("private_key", privateKey);
	}

	public java.lang.String getPrivateKey() {
		return get("private_key");
	}

	public void setPublicKey(java.lang.String publicKey) {
		set("public_key", publicKey);
	}

	public java.lang.String getPublicKey() {
		return get("public_key");
	}

	public void setAlipayPublicKey(java.lang.String alipayPublicKey) {
		set("alipay_public_key", alipayPublicKey);
	}

	public java.lang.String getAlipayPublicKey() {
		return get("alipay_public_key");
	}

	public void setWeixinAppid(java.lang.String weixinAppid) {
		set("weixin_appid", weixinAppid);
	}

	public java.lang.String getWeixinAppid() {
		return get("weixin_appid");
	}

	public void setWeixinAppkey(java.lang.String weixinAppkey) {
		set("weixin_appkey", weixinAppkey);
	}

	public java.lang.String getWeixinAppkey() {
		return get("weixin_appkey");
	}

	public void setWeixinPartner(java.lang.String weixinPartner) {
		set("weixin_partner", weixinPartner);
	}

	public java.lang.String getWeixinPartner() {
		return get("weixin_partner");
	}

	public void setWeixinPartnerkey(java.lang.String weixinPartnerkey) {
		set("weixin_partnerkey", weixinPartnerkey);
	}

	public java.lang.String getWeixinPartnerkey() {
		return get("weixin_partnerkey");
	}

	public void setSubWeixinAppid(java.lang.String subWeixinAppid) {
		set("sub_weixin_appid", subWeixinAppid);
	}

	public java.lang.String getSubWeixinAppid() {
		return get("sub_weixin_appid");
	}

	public void setSubWeixinMchid(java.lang.String subWeixinMchid) {
		set("sub_weixin_mchid", subWeixinMchid);
	}

	public java.lang.String getSubWeixinMchid() {
		return get("sub_weixin_mchid");
	}

	public void setYipayMerchantno(java.lang.String yipayMerchantno) {
		set("yipay_merchantNo", yipayMerchantno);
	}

	public java.lang.String getYipayMerchantno() {
		return get("yipay_merchantNo");
	}

	public void setProvince(java.lang.String province) {
		set("province", province);
	}

	public java.lang.String getProvince() {
		return get("province");
	}

}
