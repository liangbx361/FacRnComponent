package com.nd.sdp.ele.rct.exam.data.exception;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/5/23.
 */
public class UnexpectedException extends RuntimeException {

    public UnexpectedException() {
    }

    public UnexpectedException(String detailMessage) {
        super(detailMessage);
    }
}
