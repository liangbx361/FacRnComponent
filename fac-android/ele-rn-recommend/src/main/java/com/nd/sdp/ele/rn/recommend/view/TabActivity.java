package com.nd.sdp.ele.rn.recommend.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
public class TabActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
    }

    public void gotoRecommend(View view) {
        Intent intent = new Intent(this, RecommendActivity.class);
        startActivity(intent);
    }
}
