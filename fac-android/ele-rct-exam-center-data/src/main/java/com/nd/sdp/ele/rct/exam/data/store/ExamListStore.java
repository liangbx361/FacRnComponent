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
 * @data 2016/7/19.
 */
public class ExamListStore extends BaseExamStore<String> {

    private String title;
    private String tagIds;
    private Integer examStatus;
    private Integer orderBy;

    private ExamListStore(String title, String tagIds, Integer examStatus, Integer orderBy) {
        this.title = title;
        this.tagIds = tagIds;
        this.examStatus = examStatus;
        this.orderBy = orderBy;
    }

    public static ExamListStore get(String title, String tagIds, Integer examStatus, Integer orderBy) {
        return new ExamListStore(title, tagIds, examStatus, orderBy);
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
        return network(0, 10);
    }

    public Observable<String> network(Integer page, Integer pageSize) {
        return getClientApi().getExamList(title, tagIds, examStatus, page, pageSize, orderBy);
    }

    @Override
    public void saveToDisk(String data) {

    }
}
