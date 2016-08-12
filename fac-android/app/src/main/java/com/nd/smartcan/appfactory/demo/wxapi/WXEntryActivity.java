package com.nd.smartcan.appfactory.demo.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.nd.smartcan.accountclient.CurrentUser;
import com.nd.smartcan.accountclient.LoginCallback;
import com.nd.smartcan.accountclient.UCManager;
import com.nd.smartcan.accountclient.core.AccountException;
import com.nd.smartcan.accountclient.thirdLogin.common.ErrorParamException;
import com.nd.smartcan.accountclient.thirdLogin.common.ThirdLoginParam;
import com.nd.smartcan.accountclient.thirdLogin.common.ThirdPlatformType;
import com.nd.smartcan.appfactory.AppFactory;
import com.nd.smartcan.appfactory.nativejs.util.MapScriptable;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/**
 * 微信登录需要制定的包名称，最终多应用打包，通过脚本动态修改包名和AndroidTemplet实现.
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "WXEntryActivity";
    public static String WECHAT_APP_KEY = "wechat_app_key_android";

    public static String WECHAT_APP_SECRET = "wechat_app_secret_android";

    public static final String EVENT_ON_WECHAT_LOGIN = "on_wechat_login";

    public static final String LOGIN_RESULT = "login_result";

    public static final String ORG = "org";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        final String org = intent.getStringExtra(ORG);
        String appKey = intent.getStringExtra(WECHAT_APP_KEY);
        String appSecret = intent.getStringExtra(WECHAT_APP_SECRET);
        ThirdLoginParam paramWX = new ThirdLoginParam.LoginParamBuilder()
                .setAppKey(appKey)
                .setAppSecret(appSecret)
                .setPlatFormType(ThirdPlatformType.PLATFORM_TYPE_WEIXIN)
                .build();

        try {
            UCManager.getInstance().loginThirdPlatform(WXEntryActivity.this, paramWX, org, new LoginCallback() {
                @Override
                public void onSuccess(CurrentUser currentUser) {
                    Log.d(TAG, "third login success");
                    MapScriptable param = new MapScriptable();
                    param.put(LOGIN_RESULT, "success");
                    AppFactory.instance().triggerEvent(WXEntryActivity.this, EVENT_ON_WECHAT_LOGIN, param);
                    finish();
                }

                @Override
                public void onCanceled() {
                    Log.e(TAG, "third login canceled");
                    MapScriptable param = new MapScriptable();
                    param.put(LOGIN_RESULT, "canceled");
                    AppFactory.instance().triggerEvent(WXEntryActivity.this, EVENT_ON_WECHAT_LOGIN, param);
                    finish();
                }

                @Override
                public void onFailed(AccountException e) {
                    Log.e(TAG, "third login failed : " + e.getErrorMessage());
                    MapScriptable param = new MapScriptable();
                    param.put(LOGIN_RESULT, "failed");
                    param.put("exception", e);
                    AppFactory.instance().triggerEvent(WXEntryActivity.this, EVENT_ON_WECHAT_LOGIN, param);
                    finish();
                }
            });
        } catch (ErrorParamException e) {
            e.printStackTrace();
        }

        UCManager.getInstance().handleThirdPlatformIntent(this, paramWX);
        finish();
    }

    @Override
    public void onReq(BaseReq baseReq) {
        Log.d(TAG, "onReq");
    }

    @Override
    public void onResp(BaseResp baseResp) {
        Log.d(TAG, "onResp");
    }
}

