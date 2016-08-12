package com.nd.smartcan.appfactory.demo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
import android.text.TextUtils;
import android.util.Log;

import com.nd.component.utils.MainComponentUtils;
import com.nd.smartcan.appfactory.AppFactory;
import com.nd.smartcan.appfactory.businessInterface.IComponentEntryInterface;
import com.nd.smartcan.appfactory.component.ComponentEntry;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cq on 2015/5/4.<br/>
 * <p/>
 * 描述： 框架初始化部分.
 */
public final class ContainerApplication extends Application implements IComponentEntryInterface {

    private static final String KEY_DEX2_SHA1 = "nd_appfactory_dex_sha";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MainComponentUtils.setBeginTimeMills(System.currentTimeMillis());
        Log.w("appPerformance", "App attachBaseContext ");
        if (IS_VM_MULTIDEX_CAPABLE) {//如果vm支持multidex,则不需要处理
            Log.i("ContainerApplication", "VM has multidex support, MultiDex support library is disabled.");
        } else if (!quickStart()) {// 判断是否进程B
            // 是否需要opt，
            if (needWait(base)) {
                // 如果需要，进入sleep等待opt
                waitForDexopt(base);
            }
            // 不需要等待和需要等待的情况都进行install操作
            MultiDex.install(this);
        } else {
            return;
        }
        Log.w("appPerformance", " end App attachBaseContext ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("appPerformance", " check app  onCreate ");
        if (!IS_VM_MULTIDEX_CAPABLE&&quickStart()) {
            return;
        }
//        Log.w("appPerformance", " begin app  onCreate ");
//        boolean isImNotFactoryInitial=ImProcUtils.isCurProcBelongToIMSecondProc(this);
//        Log.w("ContainerApplication","当前进程是否属于 isCurProcBelongToIMSecondProc"+isImNotFactoryInitial);
//        if(!isImNotFactoryInitial) {
//            ClassDelegate.onCreate(this);
//        }

        ClassDelegate.onCreate(this);
        AppFactory.instance().setComponentEntryInterface(this.getClass().getSimpleName(), this);
        Log.w("appPerformance", " end app  onCreate ");
    }

    public boolean quickStart() {
        String processName = getCurProcessName(this);
        Log.d("loadDex", "processName : " + processName);
        if (!TextUtils.isEmpty(processName) && processName.contains(":mini")) {
            Log.d("loadDex", ":mini start!");
            return true;
        }
        return false;
    }

    //是否需要opt
    private boolean needWait(Context context) {
        String flag = get2thDexSHA1(context);
        Log.d("loadDex", "dex2-sha1 " + flag);
        SharedPreferences sp = context.getSharedPreferences(
                context.getPackageName() + KEY_DEX2_SHA1, MODE_MULTI_PROCESS);
        String saveValue = sp.getString(KEY_DEX2_SHA1, "");
        return !saveValue.equals(flag);
    }

    private String get2thDexSHA1(Context context) {
        Log.w("appPerformance", " begin app  get2thDexSHA1 ");
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            String versioncode = pi.versionCode + context.getPackageName();
            Log.w("appPerformance", " end app  get2thDexSHA1 define file " + versioncode);
            return versioncode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // optDex finish
    public void installFinish(Context context) {
        SharedPreferences sp = context.getSharedPreferences(
                getPackageName() + KEY_DEX2_SHA1, MODE_MULTI_PROCESS);
        sp.edit().putString(KEY_DEX2_SHA1, get2thDexSHA1(context)).commit();
    }

    public static String getCurProcessName(Context context) {
        try {
            int pid = android.os.Process.myPid();
            ActivityManager mActivityManager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                    .getRunningAppProcesses()) {
                if (appProcess.pid == pid) {
                    return appProcess.processName;
                }
            }
        } catch (Exception e) {
            // ignore
        }
        return null;
    }

    public void waitForDexopt(Context base) {
        Intent intent = new Intent();
        ComponentName componentName = new
                ComponentName(getPackageName(), LoadDexActivity.class.getName());
        intent.setComponent(componentName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        base.startActivity(intent);
        long startWait = System.currentTimeMillis();
        long waitTime = 10 * 1000;
        while (needWait(base)) {
            try {
                long nowWait = System.currentTimeMillis() - startWait;
                Log.d("loadDex", "wait ms :" + nowWait);
                if (nowWait >= waitTime) {
                    return;
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTerminate() {
        ClassDelegate.onTerminate();
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (!quickStart()) {
            ClassDelegate.onConfigurationChanged(newConfig);
            Log.d("loadDex", "ClassDelegate onConfigurationChanged");
        } else {
            Log.d("loadDex", "in quickStart, cannot call ClassDelegate onConfigurationChanged");
        }
    }

    @Override
    public List<ComponentEntry> getComponentEntryList(String env) {
        if (!TextUtils.isEmpty(env)) {
            List<ComponentEntry> componentEntries =  ComponentEntryUtil.instance().getComponentEntryList(env);
            if (componentEntries != null && componentEntries.size() > 0) {
                return ComponentEntryUtil.instance().getComponentEntryList(env);
            }
        }
        return null;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * vm是否支持multidex
     *
     * @return vm是否支持multidex
     */
    private static boolean isVmMultidexCapable() {
        return IS_VM_MULTIDEX_CAPABLE;
    }

    /**
     * vm是否支持multidex
     */
    private static final boolean IS_VM_MULTIDEX_CAPABLE =
            isVMMultidexCapable(System.getProperty("java.vm.version"));
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;

    /**
     * Identifies if the current VM has a native support for multidex, meaning there is no need for
     * additional installation by this library.
     *
     * @return true if the VM handles multidex(就是虚拟机本身支持不用合并包功能)
     */
    /* package visible for test */
    private static boolean isVMMultidexCapable(String versionString) {
        boolean isMultidexCapable = false;
        if (versionString != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(versionString);
            if (matcher.matches()) {
                try {
                    int major = Integer.parseInt(matcher.group(1));
                    int minor = Integer.parseInt(matcher.group(2));
                    isMultidexCapable = (major > VM_WITH_MULTIDEX_VERSION_MAJOR)
                            || ((major == VM_WITH_MULTIDEX_VERSION_MAJOR)
                            && (minor >= VM_WITH_MULTIDEX_VERSION_MINOR));
                } catch (NumberFormatException e) {
                    // let isMultidexCapable be false
                }
            }
        }
        Log.i("ContainerApplication", "VM with version " + versionString +
                (isMultidexCapable ?
                        " has multidex support" :
                        " does not have multidex support"));
        return isMultidexCapable;
    }
}
