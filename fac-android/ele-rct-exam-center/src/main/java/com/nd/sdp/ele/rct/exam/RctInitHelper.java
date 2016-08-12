package com.nd.sdp.ele.rct.exam;

import android.app.Application;
import android.util.Log;

import com.nd.hy.android.frame.ElearningConfigs;
import com.nd.sdp.android.uc.client.UcClient;
import com.nd.sdp.ele.rct.exam.data.EleExamCenter;
import com.nd.sdp.ele.rct.exam.data.config.EleExamCenterPlatform;
import com.nd.sdp.ele.rct.exam.data.config.ExamCenterPlatform;
import com.nd.smartcan.appfactory.keying.ProtocolConstant;

import retrofit.RequestInterceptor;


/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/19.
 */
public class RctInitHelper {

    public static void onInit(Application application, ProtocolConstant.ENV_TYPE envType) {
        RctManager.INSTANCE.init(application, false, new FacPackage());
        //初始化密钥组件
        ElearningConfigs.init(envType);
        EleExamCenter.init(application.getApplicationContext(), getEnv(envType), new UcClient(), new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                String appKey = ElearningConfigs.getSyncAppKey();
                Log.d("appKey", appKey);
                if (appKey == null) {
                    appKey = "";
                }
//                request.addHeader("X-Gaea-Authorization", "GAEA id=\"" + appKey + "\"");

                request.addHeader("X-Gaea-Authorization", "GAEA id=Dm7L4yH/eQU=");
            }
        });
    }

    public static void onDestroy() {
        RctManager.INSTANCE.destroy();
    }

    private static ExamCenterPlatform getEnv(ProtocolConstant.ENV_TYPE envType) {
        switch (envType) {
            case DEV:
                return EleExamCenterPlatform.DEV;

            case TEST:
                return EleExamCenterPlatform.TEST;

            case PRE_FORMAL:
                return EleExamCenterPlatform.PRE_FORMAL;

            case AWS:
                return EleExamCenterPlatform.AWS;

            case PARTY_HOME:
                return EleExamCenterPlatform.DYEJIA;

            case FORMAL:
            default:
                return EleExamCenterPlatform.RELEASE;
        }
    }
}
