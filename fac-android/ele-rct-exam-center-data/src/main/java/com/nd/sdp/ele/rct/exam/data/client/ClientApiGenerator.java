package com.nd.sdp.ele.rct.exam.data.client;


import com.nd.hy.android.hermes.frame.base.HermesLogger;
import com.nd.sdp.ele.rct.exam.data.common.RetrofitErrorHandler;
import com.nd.sdp.ele.rct.exam.data.common.StringConverter;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.Converter;

public class ClientApiGenerator {

    public static <T> T buildApi(Class<T> clazz,
                                 String baseUrl,
                                 RequestInterceptor interceptor,
                                 Client client) {
        return buildApi(clazz,
                client,
                baseUrl,
                new DefaultLogger(),
                new StringConverter(),
                interceptor,
                new RetrofitErrorHandler());
    }

    public static <T> T buildApi(Class<T> clazz,
                                 Client client,
                                 String baseUrl,
                                 RestAdapter.Log logger,
                                 Converter converter,
                                 RequestInterceptor interceptor,
                                 retrofit.ErrorHandler errorHandler) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setLog(logger)
                .setConverter(converter)
                .setClient(client)
                .setRequestInterceptor(interceptor)
                .setErrorHandler(errorHandler)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return adapter.create(clazz);
    }

    private static class DefaultLogger implements RestAdapter.Log {

        @Override
        public void log(String message) {
            HermesLogger.D.print(message);
        }
    }
}
