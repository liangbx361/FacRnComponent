package com.nd.sdp.ele.rct.exam.data.depend;

import android.content.Context;

import com.nd.sdp.ele.rct.exam.data.client.ClientApi;
import com.nd.sdp.ele.rct.exam.data.client.ClientApiGenerator;
import com.nd.sdp.ele.rct.exam.data.config.EleExamCenterPlatform;
import com.nd.sdp.ele.rct.exam.data.config.ExamCenterPlatform;
import com.nd.sdp.ele.rct.exam.data.mock.MockClientApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
 * @data 2016/3/24.
 */
@Module
public class EleCourseDataModule {

    private Context mContext;
    private Client mClient;
    private RequestInterceptor mInterceptor;
    public ExamCenterPlatform mPlatform = EleExamCenterPlatform.MOCK;

    public EleCourseDataModule(Context context, ExamCenterPlatform platform, Client client) {
        mContext = context.getApplicationContext();
        mClient = client;
        mPlatform = platform;
    }

    public EleCourseDataModule(Context context, ExamCenterPlatform platform, Client client, RequestInterceptor interceptor) {
        mContext = context.getApplicationContext();
        mClient = client;
        mInterceptor = interceptor;
        mPlatform = platform;
    }

    @Provides
    @Singleton
    public Context provideGlobalContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public ClientApi provideClientApi(Context context, RequestInterceptor interceptor, Client client) {
        if (!mPlatform.isMock()) {
            return ClientApiGenerator.buildApi(ClientApi.class, mPlatform.getBaseUrl(), interceptor, client);
        } else {
            return new MockClientApi(context);
        }
    }

    @Provides
    @Singleton
    public RequestInterceptor provideRequestInterceptor() {
        if(mInterceptor != null) {
            return mInterceptor;
        } else {
            return new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {

                }
            };
        }
    }

    @Provides
    @Singleton
    public Client provideClient() {
        return mClient;
    }
}
