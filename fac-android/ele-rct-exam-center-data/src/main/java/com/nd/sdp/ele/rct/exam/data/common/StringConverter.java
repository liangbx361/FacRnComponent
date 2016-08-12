package com.nd.sdp.ele.rct.exam.data.common;

import com.nd.hy.android.commons.util.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/19.
 */
public class StringConverter implements Converter {

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {

        try {
            return IOUtils.readToString(body.in());
        } catch (IOException e) {
            throw new ConversionException(e);
        }
    }

    @Override
    public TypedOutput toBody(Object object) {
        return new TypedByteArray("react-native", object.toString().getBytes());
    }
}
