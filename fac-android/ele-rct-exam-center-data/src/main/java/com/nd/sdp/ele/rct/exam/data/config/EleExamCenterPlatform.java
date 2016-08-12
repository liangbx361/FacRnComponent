package com.nd.sdp.ele.rct.exam.data.config;

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
public enum EleExamCenterPlatform implements ExamCenterPlatform {

    MOCK {
        @Override
        public String getBaseUrl() {
            return "";
        }

        @Override
        public boolean isMock() {
            return true;
        }
    },

    DEV {
        @Override
        public String getBaseUrl() {
            return DEV_BASE_URL;
        }

        @Override
        public boolean isMock() {
            return false;
        }
    },

    TEST {
        @Override
        public String getBaseUrl() {
            return TEST_BASE_URL;
        }

        @Override
        public boolean isMock() {
            return false;
        }
    },

    PRE_FORMAL {
        @Override
        public String getBaseUrl() {
            return FORMAL_BASE_URL;
        }

        @Override
        public boolean isMock() {
            return false;
        }
    },

    RELEASE {
        @Override
        public String getBaseUrl() {
            return RELEASE_BASE_URL;
        }

        @Override
        public boolean isMock() {
            return false;
        }
    },

    AWS {
        @Override
        public String getBaseUrl() {
            return AWS_BASE_URL;
        }

        @Override
        public boolean isMock() {
            return false;
        }
    },

    DYEJIA {
        @Override
        public String getBaseUrl() {
            return DYEJIA_BASE_URL;
        }

        @Override
        public boolean isMock() {
            return false;
        }
    };

    //开发的配置
    private static final String DEV_BASE_URL = "http://auxo-exam-center-gateway.dev.web.nd";

    //测试的配置
    private static final String TEST_BASE_URL = "http://auxo-exam-center-gateway.debug.web.nd";

    //预生产的配置
    private static final String FORMAL_BASE_URL = "http://auxo-exam-center-gateway.beta.web.sdp.101.com";

    //生产的配置
    private static final String RELEASE_BASE_URL = "http://auxo-exam-center-gateway.edu.web.sdp.101.com";
//    http://auxo-exam-center-gateway.edu.web.sdp.101.com/v1/exam_center/exams?page=0&size=10&order_by=1

    //AWS的配置
    private static final String AWS_BASE_URL = TEST_BASE_URL;

    //党员e家的配置
    private static final String DYEJIA_BASE_URL = RELEASE_BASE_URL;
}
