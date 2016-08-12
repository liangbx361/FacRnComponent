package com.nd.sdp.ele.rct.exam.data.exception;


import com.nd.sdp.ele.rct.exam.data.model.ErrorEntry;

/**
 * 内服服务端异常，对应服务端500错误
 */
public class InternalServerException extends ShowToastException {

    public static final int ERROR_CODE = 500;

    private ErrorEntry mErrorEntry;

    public InternalServerException() {
    }

    public InternalServerException(String detail, ErrorEntry errorEntry, Throwable throwable) {
        super(detail, throwable);
        mErrorEntry = errorEntry;
    }

    public InternalServerException(String detailMessage) {
        super(detailMessage);
    }

    public InternalServerException(Throwable throwable) {
        super(throwable);
    }

    public String getCode() {
        if (mErrorEntry != null) {
            return mErrorEntry.getCode();
        } else {
            return "";
        }
    }

    public ErrorEntry getErrorEntry() {
        return mErrorEntry;
    }

}
