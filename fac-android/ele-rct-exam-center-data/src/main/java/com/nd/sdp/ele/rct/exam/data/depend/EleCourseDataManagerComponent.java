package com.nd.sdp.ele.rct.exam.data.depend;

import com.nd.sdp.ele.rct.exam.data.store.CourseServiceManager;
import com.raizlabs.android.dbflow.annotation.NotNull;

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
public interface EleCourseDataManagerComponent {

    void inject(CourseServiceManager manager);

    class Instance {
        private volatile static EleCourseDataManagerComponent sEleCourseManager;

        public static void init(@NotNull EleCourseDataManagerComponent component) {
            if(sEleCourseManager == null) {
                synchronized (Instance.class) {
                    if (sEleCourseManager == null) {
                        sEleCourseManager = component;
                    }
                }
            }
        }

        public static EleCourseDataManagerComponent get() {
            return sEleCourseManager;
        }
    }
}
