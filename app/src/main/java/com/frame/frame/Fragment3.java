package com.frame.frame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.frame.library.base.BaseFragment;
import com.frame.library.base.BaseViewModel;

public class Fragment3 extends BaseFragment {
    public static Fragment3 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment3 fragment = new Fragment3();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected BaseViewModel createViewModel() {
        return null;
    }

    @Override
    protected void initView(View rootView) {
        TextView textView = rootView.findViewById(R.id.tv);
        textView.setText("Fragment3");
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment1_layout;
    }

    @Override
    protected void onLazyLoad() {
        Log.e("Fragment3", "onLazyLoad: Fragment3" );
    }
}
