package com.nd.smartcan.appfactory.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.nd.smartcan.appfactory.AppFactory;
import com.nd.smartcan.appfactory.component.ComponentBase;
import com.nd.smartcan.appfactory.vm.InitialTaskManager;
import com.nd.smartcan.appfactory.vm.PageUri;
import com.nd.smartcan.core.restful.LogHandler;

/**
 * 这个节目主要是欢迎界面，
 * 目的是为了减少白屏
 * 和初始界面的图片可设置。
 */
public class SplashActivity extends Activity {

    private static final String TAG = "SplashActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("appPerformance", " begin SplashActivity  onCreate ");
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        mContext = this;
        Log.w("appPerformance", " end SplashActivity  onCreate ");

        // 设置监听，等到AppFactory的异步加载结束，闪屏页再结束。（有些Component需要等到自己的异步初始化完成
        // 之后才能使用，这时候就需要在这里阻塞住，等到它完成，或者AppFactory的等待超时——由AppFactory控制）
        AppFactory.instance().setInitialTaskListener(new InitialTaskManager.IInitailTaskListener() {
            @Override
            public void done(boolean isAllDone) {
                if (!isAllDone) {
                    Log.w(TAG, "Some initial task have not done");
                }

                SplashActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        goNextPage();
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //只有在goPage对方成功打开新界面时候才把自己finish，避免由于配置goPageUrl 错误没有打开新界面，而这边又把自己关闭，被误解为闪退
        Log.w("SplashActivity", "onPause finish self ");
        finish();
    }
    /**
     * 获取属性，用来配置博睿的sdk 的key
     *
     * @return
     */
    private String getSdkKey() {
        long beginTime=System.currentTimeMillis();
        String value = "b66db0e1-42d3-4507-ad7d-58e0e2fe8b59";
        ComponentBase base = AppFactory.instance().getComponent("com.nd.smartcan.appfactory.main_component");
        if (base != null) {
            String temp = base.getProperty("bonree_app_key_android", "b66db0e1-42d3-4507-ad7d-58e0e2fe8b59");
            if (temp != null) {
                temp = temp.trim();
            }
            if (!TextUtils.isEmpty(temp)) {
                value = temp;
            }
        }
        Log.w("appPerformance", "  SplashActivity  getSdkKey "+(System.currentTimeMillis()-beginTime)+" key =["+value+"]");
        return value;


    }


    private void goNextPage() {
        String launcherUrl = AppFactory.instance().getEnvironment("launcher");
//        launcherUrl = "cmp://com.nd.hy.e-exam/eexam?exam_id=ec88d977-a1d5-4cd7-b8d7-705f004b373d";
        LogHandler.i(TAG, " launcherUrl value is " + launcherUrl);
        if (TextUtils.isEmpty(launcherUrl) || !AppFactory.instance().isValidPageUrl(new PageUri(launcherUrl))) {
            new AlertDialog.Builder(mContext).setMessage(R.string.android_templet_page_not_correct).setPositiveButton(R.string.maincomponent_confirm, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    finish();
                }
            }).create().show();
        } else {
            AppFactory.instance().goPage(mContext, launcherUrl);
            //finish();
        }

        Log.w("appPerformance", " end SplashActivity  onPostExecute " + launcherUrl);
    }


}
