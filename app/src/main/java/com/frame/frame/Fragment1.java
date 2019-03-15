package com.frame.frame;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.library.base.BaseListFragment;
import com.frame.library.entity.Article;

import java.util.ArrayList;

public class Fragment1 extends BaseListFragment<Article.DatasBean, Fragment1VM> {
    public static Fragment1 newInstance() {

        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter<Article.DatasBean, BaseViewHolder> getAdapter() {
        return new ArticleAdapter(R.layout.item_atcitle, new ArrayList<>());
    }

    @Override
    protected void requestData() {
        viewModel.getData(pageIndex, isFirstRequest).observe(this, this::setListData);
    }

    @Override
    protected Fragment1VM createViewModel() {
        return ViewModelProviders.of(this).get(Fragment1VM.class);
    }
}
