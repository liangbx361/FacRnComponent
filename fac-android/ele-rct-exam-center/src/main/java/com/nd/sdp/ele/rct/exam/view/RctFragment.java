package com.nd.sdp.ele.rct.exam.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.ReactRootView;
import com.nd.sdp.ele.rct.exam.RctManager;

/**
 * <p>Title: <／p>
 * <p>Description: FIXME 未处理Back键<／p>
 * <p>Copyright: Copyright (c) 2016<／p>
 * <p>Company: 网龙公司<／p>
 *
 * @author liangbx
 * @version 1.0
 * @data 2016/7/19.
 */
public class RctFragment extends Fragment {

    private static final String MODULE_NAME = "module_name";
    private String moduleName;
    private ReactRootView mReactRootView;

    public static RctFragment newInstance(String moduleName) {
        RctFragment fragment = new RctFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MODULE_NAME, moduleName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        moduleName = getArguments().getString(MODULE_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new ReactRootView(getActivity());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mReactRootView = (ReactRootView) view;
        if(!TextUtils.isEmpty(moduleName)) {
            mReactRootView.startReactApplication(RctManager.INSTANCE.get(), moduleName, null);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(RctManager.INSTANCE.get() != null) {
//            RctManager.INSTANCE.get().onPause();
            RctManager.INSTANCE.get().onHostPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if(RctManager.INSTANCE.get() != null) {
//            RctManager.INSTANCE.get().onResume(getActivity(), null);
            RctManager.INSTANCE.get().onHostResume(getActivity(), null);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(RctManager.INSTANCE.get() != null) {
//            RctManager.INSTANCE.get().onDestroy();
            RctManager.INSTANCE.get().onHostDestroy();
        }
    }
}
