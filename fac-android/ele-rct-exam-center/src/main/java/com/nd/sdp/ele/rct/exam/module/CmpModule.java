package com.nd.sdp.ele.rct.exam.module;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.nd.hy.android.ele.exam.view.prepare.ExamPrepareActivity;
import com.nd.smartcan.appfactory.vm.PageUri;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/18.
 */
public class CmpModule extends ReactContextBaseJavaModule {

    public CmpModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "NativeCmp";
    }

    @ReactMethod
    public void goPage(String cmp, Promise promise) {
        //应用工厂cmp协议
//        AppFactory.instance().goPage(getCurrentActivity(), cmp);
//        promise.resolve(true);

        PageUri uri = new PageUri(cmp);
        String examId = uri.getParam().get("examId");
        ExamPrepareActivity.launch(getCurrentActivity(), examId);
    }
}
