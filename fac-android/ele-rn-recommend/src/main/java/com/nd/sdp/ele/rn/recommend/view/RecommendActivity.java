package com.nd.sdp.ele.rn.recommend.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.nd.rn.common.view.BaseRnActivity;
import com.nd.rn.common.view.BaseRnFragment;
import com.nd.sdp.ele.rn.recommend.R;

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
public class RecommendActivity extends BaseRnActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recommend);
        showRecommend();
    }

    private void showRecommend() {
        Fragment fragment = BaseRnFragment.newInstance("FacRnComponent");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_recommend, fragment, "recommend");
        transaction.commit();
    }
}
