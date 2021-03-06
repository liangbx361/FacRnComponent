package com.nd.sdp.ele.rct.exam;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.nd.sdp.ele.rct.exam.module.CmpModule;
import com.nd.sdp.ele.rct.exam.module.NativeNavigationModule;
import com.nd.sdp.ele.rct.exam.module.ReqExamModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/13.
 */
public class FacPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new CmpModule(reactContext));
        modules.add(new ReqExamModule(reactContext));
        modules.add(new NativeNavigationModule(reactContext));
        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return new ArrayList<>();
    }
}
