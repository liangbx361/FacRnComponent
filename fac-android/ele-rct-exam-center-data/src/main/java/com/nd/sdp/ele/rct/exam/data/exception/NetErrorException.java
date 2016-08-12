package com.nd.sdp.ele.rct.exam.data.exception;

/**
 * 内服服务端异常，对应服务端500错误
 */
public class NetErrorException extends ShowToastException {

    public static final int ERROR_CODE = 400;

    private Integer mStatus;

    public NetErrorException(String detail, Throwable throwable) {
        super(detail, throwable);
        mStatus = ERROR_CODE;
    }

    public Integer getCode() {
        return mStatus;
    }

}
