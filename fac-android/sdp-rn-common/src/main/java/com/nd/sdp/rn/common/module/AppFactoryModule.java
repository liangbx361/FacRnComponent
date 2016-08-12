package com.nd.sdp.rn.common.module;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.nd.smartcan.appfactory.AppFactory;
import com.nd.smartcan.appfactory.keying.ProtocolConstant;

/**
 * <p>Title: 提供应用工厂相关的API能力<／p>
 * <p>Description: 包含页面跳转、获取单前环境等<／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/18.
 */
public class AppFactoryModule extends ReactContextBaseJavaModule {

    public AppFactoryModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SdpAppFactory";
    }

    /**
     *
     * @param page 页面uri
     * @param promise 是否成功回调
     */
    @ReactMethod
    public void goPage(String page, Promise promise) {
        AppFactory.instance().goPage(getCurrentActivity(), page);
        promise.resolve(true);
    }

    /**
     * 获取当前的环境
     */
    @ReactMethod
    public void getEnvType(Promise promise) {
        ProtocolConstant.ENV_TYPE envType = AppFactory.instance().getConfigManager().getEnvironment();
        promise.resolve(envType.ordinal());
    }

}
