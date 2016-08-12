package com.nd.sdp.ele.rct.exam.base;

import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.nd.sdp.ele.rct.exam.RctManager;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/20.
 */
public class BaseRctActivity extends FragmentActivity {

    @Override
    public void onBackPressed() {
        if (RctManager.INSTANCE.get() != null) {
            RctManager.INSTANCE.get().onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && RctManager.INSTANCE.get() != null &&
                RctManager.INSTANCE.get().getDevSupportManager().getDevSupportEnabled()) {
            RctManager.INSTANCE.get().showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
