package com.nd.sdp.ele.rn.recommend;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.nd.sdp.ele.rn.recommend.view.RecommendActivity;
import com.nd.sdp.ele.rn.recommend.view.TabActivity;
import com.nd.smartcan.appfactory.component.ComponentBase;
import com.nd.smartcan.appfactory.component.ICallBackListener;
import com.nd.smartcan.appfactory.vm.PageUri;
import com.nd.smartcan.appfactory.vm.PageWrapper;

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
public class RecommendComponent extends ComponentBase {

    @Override
    public void onInit() {
        RecommendInitHelper.onInit((Application) getContext().getApplicationContext());
    }

    @Override
    public void onDestroy() {
        RecommendInitHelper.onDestroy();
    }

    @Override
    public void goPage(Context context, PageUri page) {
        Intent intent = new Intent(context, RecommendActivity.class);
        context.startActivity(intent);
    }

    @Override
    public PageWrapper getPage(Context context, PageUri page) {
        return new PageWrapper(TabActivity.class.getName());
    }

    @Override
    public void goPageForResult(PageUri page, ICallBackListener callBackListener) {

    }
}
