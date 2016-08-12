package com.nd.sdp.ele.rct.exam.module;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.nd.sdp.ele.rct.exam.data.store.ExamListStore;
import com.nd.sdp.ele.rct.exam.data.store.ExamTagStore;

import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/20.
 */
public class ReqExamModule extends ReactContextBaseJavaModule {

    public ReqExamModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ReqExamModule";
    }

    @ReactMethod
    public void getExamList(String title, String tagIds, int examStatus, int page, int pageSize, int orderBy, final Promise promise) {
        ExamListStore.get(title, tagIds, examStatus, orderBy).network(page, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        promise.resolve(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        promise.reject(throwable);
                    }
                });
    }

    @ReactMethod
    public void getExamTags(String customType, final Promise promise) {
        ExamTagStore.get(customType).network()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        promise.resolve(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        promise.reject(throwable);
                    }
                });
    }
}
