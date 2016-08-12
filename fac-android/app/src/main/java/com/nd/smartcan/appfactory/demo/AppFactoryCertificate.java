package com.nd.smartcan.appfactory.demo;

import com.nd.component.ICertificate;

/**
 *
 * 签名类
 * Created by syc on 2015/9/14.
 */
public class AppFactoryCertificate implements ICertificate {

    private String mPublicKey=BuildConfig.signPublicKey;


    private String mSerialNumber=null;


    /**
     * 获取公钥信息。
     */
    @Override
    public String getPublicKey() {
        return mPublicKey;
    }

    /**
     * 获取序列号。
     */
    @Override
    public String getSerialNumber() {
        return mSerialNumber;
    }
}
