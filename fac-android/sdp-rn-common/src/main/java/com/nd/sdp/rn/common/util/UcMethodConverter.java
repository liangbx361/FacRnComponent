package com.nd.sdp.rn.common.util;

import com.nd.android.smartcan.network.Method;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/6/1.
 */
public class UcMethodConverter {

    public static int convertToUcMethod(String methodStr) {
        methodStr = methodStr.toUpperCase();
        int method = Method.GET;
        switch (methodStr) {
            case "DEPRECATED_GET_OR_POST":
                method = Method.DEPRECATED_GET_OR_POST;
                break;
            case "GET":
                method = Method.GET;
                break;
            case "POST":
                method = Method.POST;
                break;
            case "PUT":
                method = Method.PUT;
                break;
            case "DELETE":
                method = Method.DELETE;
                break;
            case "HEAD":
                method = Method.HEAD;
                break;
            case "OPTIONS":
                method = Method.OPTIONS;
                break;
            case "TRACE":
                method = Method.TRACE;
                break;
        }
        return method;
    }
}
