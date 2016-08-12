package com.nd.sdp.ele.rct.exam.data.client;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

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
public interface ClientApi {

    String CUSTOM_ID = "custom_id";
    String CUSTOM_TYPE = "custom_type";
    String EXAM_STATUS ="exam_status";
    String PAGE = "page";
    String SIZE = "size";
    String ORDER_BY = "order_by";
    String TITLE = "title";
    String TAG_IDS = "tag_ids";


    /**
     * 获取用户考试信息列表
     */
    @GET("/v1/exam_center/exams")
    Observable<String> getExamList(
                                   @Query(TITLE) String title,
                                   @Query(TAG_IDS) String tagIds,
                                   @Query(EXAM_STATUS) Integer examStatus,
                                   @Query(PAGE) Integer page,
                                   @Query(SIZE) Integer size,
                                   @Query(ORDER_BY) Integer orderBy);

    /**
     * 获取标签树
     */
    @GET("/v1/exam_center/tags")
    Observable<String> getExamTags(@Query(CUSTOM_TYPE) String customType);
}
