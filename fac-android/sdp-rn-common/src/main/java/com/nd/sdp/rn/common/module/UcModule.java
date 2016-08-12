package com.nd.sdp.rn.common.module;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.nd.hy.android.commons.util.device.UserAgentUtils;
import com.nd.sdp.rn.common.util.UCManagerUtil;
import com.nd.sdp.rn.common.util.UcMethodConverter;
import com.nd.sdp.rn.common.util.UrlUtil;
import com.nd.smartcan.core.restful.ClientResourceUtils;
import com.nd.smartcan.core.security.SecurityDelegate;
import com.nd.smartcan.frame.util.AppContextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/8/8.
 */
public class UcModule extends ReactContextBaseJavaModule {

    public UcModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SdpUc";
    }

    /**
     * 获取UC头部参数
     * @param url 请求地址
     * @param method 请求方法
     * @param promise （ReadableMap）
     */
    @ReactMethod
    public void getUcHeader(String url, String method, Promise promise) {
        try {
            WritableMap map = Arguments.createMap();
            if (UCManagerUtil.isUserLogin()) {
                map.putString("Authorization", getAuthHeader(url, method));
            }

            map.putString("Accept", "application/sdp+json");
            map.putString("User-Agent", UserAgentUtils.get(AppContextUtils.getContext()));
            map.putString("Accept-Language", ClientResourceUtils.getAppMafAcceptLanguage());

            promise.resolve(map);
        } catch (JSONException e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    private String getAuthHeader(String url, String method) throws JSONException {
        String authInfo = "";

        URI uri = URI.create(url);
        String host = uri.getAuthority();
        String resourceId = UrlUtil.getResourceId(host, uri.toString());

        String mACContent = SecurityDelegate.getInstance().calculateMACContent(
                UcMethodConverter.convertToUcMethod(method), host, resourceId, false);

        JSONObject json = new JSONObject(mACContent);
        authInfo = " MAC id=\"" + json.optString("access_token")
                + "\",nonce=\"" + json.optString("nonce")
                + "\",mac=\"" + json.optString("mac") + "\"";

        return authInfo;
    }
}
