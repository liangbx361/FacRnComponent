package com.nd.sdp.ele.rct.exam;

import android.app.Application;

import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/12.
 */
public enum RctManager {

    INSTANCE;

    ReactInstanceManager mInstanceManager;

    public void init(Application application, boolean debug, ReactPackage userPackage) {
        ReactInstanceManager.Builder builder = ReactInstanceManager.builder()
                .setApplication(application)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(debug)
                .setInitialLifecycleState(LifecycleState.BEFORE_RESUME);

        if(userPackage != null) {
            builder.addPackage(userPackage);
        }

        mInstanceManager = builder.build();
    }

    public void destroy() {
        mInstanceManager = null;
    }

    public ReactInstanceManager get() {

        return mInstanceManager;
    }
}
