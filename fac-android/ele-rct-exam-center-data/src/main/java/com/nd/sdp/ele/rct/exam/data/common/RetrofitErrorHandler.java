package com.nd.sdp.ele.rct.exam.data.common;


import com.nd.hy.android.hermes.frame.base.AppContextUtil;
import com.nd.sdp.ele.rct.exam.center.data.R;
import com.nd.sdp.ele.rct.exam.data.exception.BizException;
import com.nd.sdp.ele.rct.exam.data.exception.InternalServerException;
import com.nd.sdp.ele.rct.exam.data.exception.NetErrorException;
import com.nd.sdp.ele.rct.exam.data.exception.SysException;
import com.nd.sdp.ele.rct.exam.data.exception.UnexpectedException;
import com.nd.sdp.ele.rct.exam.data.model.ErrorEntry;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * @author yangz
 * @version 2015/6/9.
 */
public class RetrofitErrorHandler implements ErrorHandler {

    @Override
    public Throwable handleError(RetrofitError err) {

        switch (err.getKind()) {
            case NETWORK:
                return new NetErrorException(AppContextUtil.getContext().getResources().
                        getString(R.string.ele_com_net_error_tips), err);

            case HTTP:
                //500错误
                if (err.getResponse().getStatus() == InternalServerException.ERROR_CODE) {
                    ErrorEntry entry = (ErrorEntry) err.getBodyAs(ErrorEntry.class);
                    if (entry != null) {
                        return new InternalServerException(entry.getMessage(), entry, err);
                    }
                }
                return new SysException(err.getMessage());

            case UNEXPECTED:
                return new UnexpectedException(err.getMessage());

            default:
                ErrorEntry entry = (ErrorEntry) err.getBodyAs(ErrorEntry.class);
                if (entry != null) {
                    return new BizException(entry.getMessage());
                }
                return new SysException(AppContextUtil.getContext().getResources().
                        getString(R.string.ele_com_data_error_tips));
        }
    }
}
