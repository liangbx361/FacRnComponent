package com.nd.sdp.ele.rct.exam.data.mock;

import android.content.Context;

import com.nd.sdp.ele.rct.exam.data.client.ClientApi;

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
 * @data 2016/3/24.
 */
public class MockClientApi extends BaseMockData implements ClientApi {

    public MockClientApi(Context context) {
        super(context);
    }

    @Override
    public Observable<String> getExamList(@Query(TITLE) String title, @Query(TAG_IDS) String tagIds, @Query(EXAM_STATUS) Integer examStatus, @Query(PAGE) Integer page, @Query(SIZE) Integer size, @Query(ORDER_BY) Integer orderBy) {
        return null;
    }

    @Override
    public Observable<String> getExamTags(@Query(CUSTOM_TYPE) String customType) {
        return null;
    }
}
