package com.nd.sdp.ele.rn.common.module;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.nd.hy.android.frame.ElearningConfigs;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/8/9.
 */
public class AppKeyModule extends ReactContextBaseJavaModule {

    public AppKeyModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "EleAppKey";
    }

    /**
     * 获取AppKey
     * @param promise
     */
    @ReactMethod
    public void getKey(Promise promise) {
        String appkey = ElearningConfigs.getSyncAppKey();
        promise.resolve(appkey);
    }
}
