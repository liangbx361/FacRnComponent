package com.nd.sdp.ele.rct.exam.data.exception;

/**
 * EmptyDataException
 *
 * @author yangz
 * @version 2015/9/16
 */
public class EmptyDataException extends BizException {

    public EmptyDataException() {
    }

    public EmptyDataException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public EmptyDataException(String detailMessage) {
        super(detailMessage);
    }

    public EmptyDataException(Throwable throwable) {
        super(throwable);
    }
}
