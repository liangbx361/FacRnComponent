package com.nd.sdp.ele.rct.exam.data.store;

import rx.Observable;

/**
 * @author zen
 * @version 2016/3/25
 */
public interface BaseStore<T> {

    Observable<T> bind();

    Observable<T> query();

    Observable<T> network();

    void saveToDisk(T data);

}
