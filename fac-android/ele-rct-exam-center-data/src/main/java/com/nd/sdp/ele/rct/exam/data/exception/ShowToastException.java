package com.nd.sdp.ele.rct.exam.data.exception;

/**
 * <p>Title: 需要向用户显示提示的异常<／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/5/6.
 */
public class ShowToastException extends RuntimeException {

    public ShowToastException() {
    }

    public ShowToastException(String detailMessage) {
        super(detailMessage);
    }

    public ShowToastException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ShowToastException(Throwable throwable) {
        super(throwable);
    }
}
