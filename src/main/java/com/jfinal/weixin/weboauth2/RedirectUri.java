package com.jfinal.weixin.weboauth2;

import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.models.Vmmisuser;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.SnsAccessToken;
import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.util.WeixinUtil;

import java.util.List;

/**
 * @author Javen
 *         2015年12月5日下午2:20:44
 */
public class RedirectUri extends ApiController {
    /**
     * 如果要支持多公众账号，只需要在此返回各个公众号对应的  ApiConfig 对象即可
     * 可以通过在请求 url 中挂参数来动态从数据库中获取 ApiConfig 属性值
     */
    public ApiConfig getApiConfig() {
        return WeixinUtil.getApiConfig();
    }

    public void index() {
        //用户同意授权，获取code
        String code = getPara("code");
        String appId = getApiConfig().getAppId();
        String secret = getApiConfig().getAppSecret();

        System.out.println("RedirectUri_code1: " + code);
        if (StrKit.isBlank(code)) {
            redirect(SnsAccessTokenApi.getAuthorizeURL(appId, "http://yile.izhuiyou.com/oauth2", true));
        } else {
            System.out.println("RedirectUri_code2: " + code);
            SnsAccessToken snsAccessToken = SnsAccessTokenApi.getSnsAccessToken(appId, secret, code);
            System.out.println("appId: " + appId + ", secret: " + secret + ", snsAccessToken: " + snsAccessToken);

            System.out.println("snsAccessToken: " + snsAccessToken);
            String openId = snsAccessToken.getOpenid();
            String token = snsAccessToken.getAccessToken();
            System.out.println("openId: " + openId);
            System.out.println("token: " + token);

            String sql = "select * from vmmisuser where fanopenid = ?";
            Vmmisuser vmmisuser = Vmmisuser.dao.findFirst(sql, openId);
            System.out.println("vmmisuser: " + vmmisuser);

            if (vmmisuser == null) {
                setSessionAttr("openId", openId);
                redirect("http://yile.izhuiyou.com/login");
            } else {
                setSessionAttr("userId", vmmisuser.getUserid());
                String requestPathA = getSessionAttr("requestPathA");
                System.out.println("RedirectUri_requestPathA: " + requestPathA);
                redirect(requestPathA);
            }

//            //此处写sql查询出来的sqlOpenId
//            String sqlOpenId = "";
////            String userId = "123";
//            String userId = getSessionAttr("userId");
////            if(openId != null && openId.equals(sqlOpenId)){
////            if(openId != null){
//            if (openId == null) {
//                setSessionAttr("userId", userId);
//                String requestPathA = getSessionAttr("requestPathA");
//                redirect(requestPathA);
//            } else {
//                setSessionAttr("openId", openId);
//                redirect("http://yile.izhuiyou.com/login");
//            }
        }

    }


    public void oauth() {
        System.out.println("oauth");
        String appId = getApiConfig().getAppId();
        String redirectUri = WeixinUtil.urlEncodeUTF8(PropKit.get("domain") + "/oauth2");
        String state = System.currentTimeMillis() + "";

        String url = SnsAccessTokenApi.getAuthorizeURL(appId, redirectUri, state, false);
        redirect(url);
    }

}
