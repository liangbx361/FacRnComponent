package com.nd.smartcan.appfactory.demo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.view.Window;

public class LoadDexActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.null_anim, R.anim.null_anim);
        //setContentView(R.layout.layout_load);
        new LoadDexTask().execute();
    }

    class LoadDexTask extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            try {
                MultiDex.install(getApplication());
                Log.d("loadDex", "install finish");
                //TODO 先屏蔽----------后面使用这个方法在打开
                ((ContainerApplication) getApplication()).installFinish(getApplication());
            } catch (Exception e) {
                Log.e("loadDex", e.getLocalizedMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            Log.d("loadDex", "get install finish");
            finish();
            //System.exit(0); 屏蔽代码，避免有些设备性能比较差，在两个线程切换直接会黑屏，同时不能用延后关闭，会出现线程已经被关闭，还在关闭异常
        }
    }

    @Override
    public void onBackPressed() {
        //cannot backpress
    }
}