package com.nd.sdp.ele.rn.recommend;

import android.app.Application;

import com.facebook.react.ReactPackage;
import com.nd.rn.common.RnManager;
import com.nd.sdp.ele.rn.common.EleCommonPackage;
import com.nd.sdp.rn.common.SdpCommonPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/8/10.
 */
public class RecommendInitHelper {

    public static void onInit(Application application) {
        List<ReactPackage> reactPackages = new ArrayList<>();
        reactPackages.add(new SdpCommonPackage());
        reactPackages.add(new EleCommonPackage());
        RnManager.INSTANCE.init(application, true, reactPackages);
    }

    public static void onDestroy() {
        RnManager.INSTANCE.destroy();
    }
}
