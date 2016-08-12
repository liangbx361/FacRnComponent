package com.nd.sdp.ele.rct.exam.data.exception;

/**
 * BizException
 *
 * @author yangz
 * @version 2014/11/29
 */
public class BizException extends ShowToastException {

    public BizException() {
    }

    public BizException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public BizException(String detailMessage) {
        super(detailMessage);
    }

    public BizException(Throwable throwable) {
        super(throwable);
    }
}
