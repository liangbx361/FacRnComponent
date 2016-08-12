package com.nd.sdp.ele.rct.exam;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.nd.hy.android.ele.exam.ExamPlatformHelper;
import com.nd.hy.android.ele.exam.data.config.ExamPlatform;
import com.nd.sdp.ele.rct.exam.view.ExamListActivity;
import com.nd.smartcan.appfactory.component.ComponentBase;
import com.nd.smartcan.appfactory.component.ICallBackListener;
import com.nd.smartcan.appfactory.vm.PageUri;
import com.nd.smartcan.appfactory.vm.PageWrapper;

/**
 * <p>Title: React版本测评中心组件<／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/19.
 */
public class RctExamCenterComponent extends ComponentBase {

    @Override
    public void onInit() {
        RctInitHelper.onInit((Application) getContext().getApplicationContext(), getEnvironment());

        ExamPlatform examPlatform = new ExamPlatform.Builder()
                .setEnvironment(getEnvironment())
                .build();
        ExamPlatformHelper.onInit(getContext(), examPlatform);
    }

    @Override
    public void onDestroy() {
        RctInitHelper.onDestroy();
        ExamPlatformHelper.onDestroy();
    }

    @Override
    public void afterInit() {
        super.afterInit();
        ExamPlatformHelper.afterInit();
    }

    @Override
    public void goPage(Context context, PageUri page) {
        Intent intent = new Intent(context, ExamListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public PageWrapper getPage(Context context, PageUri page) {
        return new PageWrapper(ExamListActivity.class.getName());
    }

    @Override
    public void goPageForResult(PageUri page, ICallBackListener callBackListener) {

    }
}
