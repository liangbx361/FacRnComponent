package com.nd.sdp.ele.rct.exam.data.store;


import com.nd.sdp.ele.rct.exam.data.client.ClientApi;
import com.nd.sdp.ele.rct.exam.data.depend.EleCourseDataManagerComponent;

import javax.inject.Inject;

/**
 * @author zen
 * @version 2016/3/25
 */
public enum CourseServiceManager {

    INSTANCE;

    @Inject
    ClientApi mClientApi;

    CourseServiceManager() {
        EleCourseDataManagerComponent.Instance.get().inject(this);
    }

    public ClientApi getClientApi() {
        return mClientApi;
    }
}
