package com.nd.sdp.ele.rct.exam.data;

import android.content.Context;

import com.nd.sdp.ele.rct.exam.data.config.ExamCenterPlatform;
import com.nd.sdp.ele.rct.exam.data.depend.DaggerProEleDataComponent;
import com.nd.sdp.ele.rct.exam.data.depend.EleCourseDataManagerComponent;
import com.nd.sdp.ele.rct.exam.data.depend.EleCourseDataModule;

import retrofit.RequestInterceptor;
import retrofit.client.Client;

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
public class EleExamCenter {

    public static void init(Context context, ExamCenterPlatform platform, Client client) {
        EleCourseDataManagerComponent.Instance.init(
                DaggerProEleDataComponent.builder().eleCourseDataModule(
                        new EleCourseDataModule(context, platform, client)).build());
        initDbFlow(context);
    }

    public static void init(Context context, ExamCenterPlatform platform, Client client, RequestInterceptor interceptor) {
        EleCourseDataManagerComponent.Instance.init(
                DaggerProEleDataComponent.builder().eleCourseDataModule(
                        new EleCourseDataModule(context, platform, client, interceptor)).build());
        initDbFlow(context);
    }

    //FIXME 缓存要加
    private static void initDbFlow(Context context) {
//        FlowManager.init(new FlowConfig.Builder(context).build());
//        FlowManager.initModule(com.raizlabs.android.dbflow.config);
    }
}
