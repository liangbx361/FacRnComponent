package com.nd.sdp.rn.common.util;

import com.nd.smartcan.accountclient.UCManager;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 * @author liangbx
 * @version 1.0
 * @data 2016/1/6.
 */
public class UCManagerUtil {

    public static boolean isUserLogin(){
        return null != UCManager.getInstance().getCurrentUser();
    }
}
