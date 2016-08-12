package com.nd.sdp.ele.rct.exam.data.store;

import rx.Observable;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/21.
 */
public class ExamTagStore extends BaseExamStore<String> {

    private String customType;

    private ExamTagStore(String customType) {
        this.customType = customType;
    }

    public static ExamTagStore get(String customType) {
        return new ExamTagStore(customType);
    }

    @Override
    public Observable<String> bind() {
        return null;
    }

    @Override
    public Observable<String> query() {
        return null;
    }

    @Override
    public Observable<String> network() {
        return getClientApi().getExamTags(customType);
    }

    @Override
    public void saveToDisk(String data) {

    }
}
