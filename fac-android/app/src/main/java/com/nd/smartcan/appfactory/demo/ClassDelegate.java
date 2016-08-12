package com.nd.smartcan.appfactory.demo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.nd.smartcan.accountclient.UCManager;
import com.nd.smartcan.appfactory.AppFactory;
import com.nd.smartcan.appfactory.AppFactoryConfig;
import com.nd.smartcan.appfactory.utils.ProtocolUtils;
import com.nd.smartcan.commons.util.system.SharedPreferencesUtil;
import com.nd.smartcan.frame.AppDelegate;

/**
 * Created by Administrator on 2015/11/11.
 */
public class ClassDelegate {


    private static final String TAG = "ContainerApplication";
    private static Handler mHandler = new Handler();
    private static  AppDelegate mAppDelegate;


    public static void onCreate(Application application) {
        beforeCreate(application);
        mAppDelegate=new AppDelegate(application,false);
        afterCreate(application);
    }

    private static void beforeCreate(final Context mContext) {
//        MainComManager.instance().setICertificate("AppFactoryCertificate",
//                new AppFactoryCertificate());
//        try {
//            Log.w(TAG, "检测应用签名");
//            if (!MainComponentUtils.isAPKNotBeChange(mContext)) {
//                Log.w(TAG, "应用签名不一致,退出应用");
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(mContext, R.string.maincomponent_apk_changed, Toast.LENGTH_SHORT).show();
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                    Thread.sleep(2000);
//                                    android.os.Process.killProcess(android.os.Process.myPid()); //获取PID
//                                    System.exit(0);
//                                } catch (Exception e) {
//                                }
//                            }
//                        }).start();
//                    }
//                });
//            }
//        } catch (Exception e) {
//            LogHandler.e(TAG, "应用签名不一致,退出应用出现异常，不影响使用" + e.getMessage());
//        }
    }

    private static void afterCreate(Context mContext) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        UCManager.getInstance();
                    }
                }
        ).start();
        AppFactoryConfig config = new AppFactoryConfig.Builder(mContext).build();
        SharedPreferencesUtil spUtil = new SharedPreferencesUtil(mContext);
        String currentEnv = spUtil.getString("local_config");
        if (TextUtils.isEmpty(currentEnv)) {
            currentEnv = ProtocolUtils.getLocalConfig();
        }
        Log.i(TAG, "currentEnv = " + currentEnv);
//读取组件配置新方式开始------------------ComponentEntryUtil配置组件属性------------------
//        if (!TextUtils.isEmpty(currentEnv)) {
//            List<ComponentEntry> componentEntries =  ComponentEntryUtil.instance().getComponentEntryList(currentEnv);
//            Log.i(TAG, "componentEntries is null : " + (componentEntries == null));
//            if (componentEntries != null && componentEntries.size() > 0) {
//                Log.i(TAG, "执行新应用工厂初始化方法，从ComponentEntryUtil.instance().getComponentEntryList中获取配置项");
//                AppFactory.instance().init(config, ComponentEntryUtil.instance().getComponentEntryList(currentEnv));
//                return;
//            }
//        }
//读取组件配置新方式结束------------------------------------
        Log.i(TAG, "执行原应用工厂初始化方法，从assets/app_factory/zh-CN/components/build.json中获取配置项");
        AppFactory.instance().init(config);
    }


    public static void onTerminate() {
        AppFactory.instance().onDestroy();
        mAppDelegate.release();
    }

    public static void onConfigurationChanged(Configuration newConfig) {
        ProtocolUtils.configurationLocalChange(newConfig);

    }




}
