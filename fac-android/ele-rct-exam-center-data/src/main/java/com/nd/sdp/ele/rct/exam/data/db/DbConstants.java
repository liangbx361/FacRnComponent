package com.nd.sdp.ele.rct.exam.data.db;

public interface DbConstants {

    interface Table {
        String COURSE_LIST = "course_list";
        String COURSE_INFO = "course_info";
        String COURSE_CATALOG = "course_catalog";
        String COURSE_VIDEO_PROGRESS = "course_video_progress";
        String COURSE_DOC_PROGRESS = "course_doc_progress";
        String COURSE_QUERY_LIST = "course_query_list";
        String COURSE_EXAM_LIST = "course_exam_list";
        String COURSE_USER_LIST = "course_user_list";
    }

    interface Column {
        String ID = "_id";
        String UUID = "uuid";
        String USER_ID = "user_id";
        String USER_INFO = "user_info";
        String PARENT_ID = "parent_id";
        String TITLE = "title";
        String PIC = "pic";
        String DESCRIPTION = "description";
        String USER_HOUR = "user_hour";
        String TOTAL_HOUR = "total_hour";
        String ENROLL_STATUS = "enroll_status";
        String RESOURCES = "resources";
        String SORT_NAME = "sort_num";
        String CHILDREN = "children";
        String RESOURCE_FLAG = "resource_flag";
        String RESOURCE_LIST = "resource_list";
        String ENCODE = "encode";
        String PROGRESS_DATA = "progress_data";
        String COURSE_ID = "course_id";
        String VIDEO_ID = "video_id";
        String VIDEO_URL = "video_url";
        String DOC_ID = "doc_id";
        String PIC_ID = "pic_id";
        String PIC_URL = "pic_url";
        String USER_SUIT = "user_suit";
        String COURSE_STATUS = "course_status";
        String TOTAL_TIME = "total_time";
        String EFFECTIVE_TIME = "effective_time";
        String USER_REGIST_STATUS = "user_regist_status";
        String CREATE_TIME = "create_time";
        String VIDEO_COUNT = "video_count";
        String DOCUMENT_COUNT = "document_count";
        String EXERCISE_COUNT = "exercise_count";
        String EXAM_COUNT = "exam_count";
        String LAST_STUDY_RESOURCE_TYPE = "last_study_resource_type";
        String LAST_STUDY_RESOURCE = "last_study_resource";
        String SINGLE_RESOURCE = "single_resource";
        String DURATION = "duration";
        String BEGIN_TIME = "begin_time";
        String END_TIME = "end_time";
        String EXAM_CHANCE = "exam_chance";
        String PASSING_SCORE = "passing_score";
        String TOTAL_SCORE = "total_score";
        String PROGRESS_PERCENT_CONDITION = "progress_percent_condition";
        String USER_EXAM_VO = "user_exam_vo";
        String LIMIT_ACCESS_COUNT = "limit_access_count";
        String AVAILABLE_ACCESS_COUNT = "available_access_count";
        String REGIST_START_TIME = "regist_start_time";
        String REGIST_END_TIME = "regist_end_time";
        String COURSE_START_TIME = "course_start_time";
        String COURSE_END_TIME = "course_end_time";
        String STATUS_CODE = "status_code";
        String COURSE_REGIST_TYPE = "course_regist_type";
        String TOTAL = "total";
        String APPRAISE_TOTAL_NUMBER = "appraise_total_number";
        String APPRAISE_AVG_STAR = "appraise_avg_star";
        String ACCESS= "access";
        String PROGRESS = "progress";
        String RANK = "rank";
        String SHARE_WEB_LINK = "share_weblink";
        String SEQUENTIAL = "sequential";
        String UNLOCK_TYPE= "unlock_type";
        String PRIOR_COURSE_VOS = "prior_course_vos";
        String PASS_ALL_PRIOR_COURSE = "pass_all_prior_course";
        String CUSTOM_ID = "custom_id";
    }

}
