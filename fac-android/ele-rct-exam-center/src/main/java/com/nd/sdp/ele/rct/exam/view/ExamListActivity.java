package com.nd.sdp.ele.rct.exam.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.nd.sdp.ele.rct.exam.base.BaseRctActivity;
import com.nd.sdp.ele.rct.exam.center.R;


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
public class ExamListActivity extends BaseRctActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exam_list);
        showExamList();

//        testRequest();
    }

    private void showExamList() {
        RctFragment fragment = RctFragment.newInstance("elearningDemoRN");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_exam_list, fragment, "exam_center");
        transaction.commit();
    }

//    private void testRequest() {
//        ExamListStore.get(null, null, 1).network(1, 10)
//            .subscribe(new Action1<String>() {
//                @Override
//                public void call(String s) {
//                    Log.w("exam-center", s);
//                }
//            }, new Action1<Throwable>() {
//                @Override
//                public void call(Throwable throwable) {
//                    throwable.printStackTrace();
//                }
//            });
//    }
}
