package com.nd.sdp.ele.rct.exam.data.store;

import com.nd.sdp.ele.rct.exam.data.client.ClientApi;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/19.
 */
public abstract class BaseExamStore<T> implements BaseStore<T> {

    protected ClientApi getClientApi() {
        return CourseServiceManager.INSTANCE.getClientApi();
    }
}
