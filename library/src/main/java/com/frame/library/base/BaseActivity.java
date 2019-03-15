package com.frame.library.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.frame.library.R;
import com.frame.library.app.BaseApplication;
import com.frame.library.event.ActionEvent;
import com.frame.library.utils.NetworkUtils;
import com.frame.library.utils.ToastUtil;
import com.frame.library.widget.MultipleStatusView;

public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {
    protected Context context;
    protected T viewModel;
    protected MultipleStatusView statusView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(getLayoutRes());
        context = this;
        viewModel = createViewModel();
        observeActionEvent();
        statusView = findViewById(R.id.stateful_layout);
        initView(savedInstanceState);
    }

    protected void beforeSetContentView() {
    }

    protected abstract int getLayoutRes();

    private void observeActionEvent() {
        if (viewModel != null) {
            viewModel.getAction().observe(this, actionEvent -> {
                switch (actionEvent.getAction()) {
                    case ActionEvent.SHOW_LOADING:
                        showLoading();
                        break;
                    case ActionEvent.HIDE_LOADING:
                        hideLoading();
                        break;
                    case ActionEvent.SHOW_ERROR:
                        showError(actionEvent.getMessage());
                        break;
                    case ActionEvent.SHOW_TOAST:
                        ToastUtil.showToast(actionEvent.getMessage());
                        break;
                }
            });
        }
    }

    protected void hideLoading() {
        if (statusView != null) {
            statusView.showContent();
        }
    }

    protected void showLoading() {
        if (statusView != null) {
            statusView.showLoading();
        }
    }

    protected void showError(String message) {
        ToastUtil.showToast(message);
        if (statusView != null) {
            if (!NetworkUtils.isNetworkAvailable(BaseApplication.getInstance())) {
                statusView.showNoNetwork();
            } else {
                statusView.showError();
            }
        }
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract T createViewModel();
}