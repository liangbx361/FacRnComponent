package com.nd.sdp.ele.rct.exam.data.exception;

/**
 * @author yangz
 * @version 2015/4/25
 */
public class SysException extends ShowToastException {

    public SysException() {
    }

    public SysException(String detailMessage) {
        super(detailMessage);
    }

    public SysException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public SysException(Throwable throwable) {
        super(throwable);
    }
}
