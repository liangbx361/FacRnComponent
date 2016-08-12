package com.nd.sdp.ele.rct.exam.data.mock;

import android.content.Context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.nd.hy.android.commons.data.ObjectMapperUtils;
import com.nd.hy.android.commons.util.IOUtils;
import com.nd.sdp.ele.rct.exam.data.log.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * BaseMockData
 *
 * @author yangz
 * @version 2015/9/16
 */
public class BaseMockData {

    protected Context mContext;

    public BaseMockData(Context context) {
        mContext = context;
    }

    public static <T> Observable<T> buildResult(final T data) {
        return Observable.defer(new Func0<Observable<T>>() {
            @Override
            public Observable<T> call() {
                return Observable.just(data);
            }
        });
    }

    public static <T> Observable<List<T>> buildResult(final List<T> datas) {
        return Observable.defer(new Func0<Observable<List<T>>>() {
            @Override
            public Observable<List<T>> call() {
                return Observable.just(datas);
            }
        });
    }

    public static <T> T getMockData(Context context, String name, Class<T> tClass) {
        String content = getMockString(context, name);
        T data = null;
        try {
            data = ObjectMapperUtils.getMapperInstance().readValue(content, tClass);
        } catch (IOException e) {
            Logger.e(e);
        }
        return data;
    }

    public static <T> List<T> getMockDataList(Context context, String name, Class<T> tClass) {
        String content = getMockString(context, name);
        List<T> data = null;
        try {
            data = ObjectMapperUtils.getMapperInstance().readValue(content, new TypeReference<List<T>>(){});
        } catch (IOException e) {
            Logger.e(e);
        }
        return data;
    }

    public static String getMockString(Context context, String name) {
        InputStream is = null;
        String content = "";
        try {
            is = context.getAssets().open(name);
            content = IOUtils.readToString(is);
        } catch (IOException e) {
            Logger.e(e);
        } finally {
            IOUtils.silentlyClose(is);
        }
        return content;
    }
}
