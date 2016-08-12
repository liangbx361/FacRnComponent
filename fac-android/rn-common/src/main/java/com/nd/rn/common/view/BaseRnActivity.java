package com.nd.rn.common.view;

import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.nd.rn.common.RnManager;

/**
 * <p>Title: <／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/8/10.
 */
public class BaseRnActivity extends FragmentActivity {

    @Override
    public void onBackPressed() {
        if (RnManager.INSTANCE.get() != null) {
            RnManager.INSTANCE.get().onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && RnManager.INSTANCE.get() != null &&
                RnManager.INSTANCE.get().getDevSupportManager().getDevSupportEnabled()) {
            RnManager.INSTANCE.get().showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
