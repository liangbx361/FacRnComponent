package com.nd.sdp.rn.common.util;

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
public class UrlUtil {

    public static String getResourceId(String host, String uri) {
        if (host == null || host.length() < 0) {
            return "";
        }
        int index = uri.indexOf(host);
        if (index == -1) {
            return "";
        }

        return uri.substring(index + host.length());
    }
}
