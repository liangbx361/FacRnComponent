package com.nd.sdp.ele.rct.exam.module;

import android.content.Intent;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.nd.sdp.ele.rct.exam.view.ExamActivity;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/22.
 */
public class NativeNavigationModule extends ReactContextBaseJavaModule{

    public NativeNavigationModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "NativeNavigationModule";
    }

    @ReactMethod
    public void goExamPage(Promise promise) {
        if(getCurrentActivity() != null && !getCurrentActivity().isFinishing()) {
            Intent intent = new Intent(getCurrentActivity(), ExamActivity.class);
            getCurrentActivity().startActivity(intent);
            promise.resolve(true);
        } else {
            promise.reject(new IllegalStateException("activity is enable"));
        }
    }
}
