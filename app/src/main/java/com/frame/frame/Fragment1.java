package com.frame.frame;

import android.arch.lifecycle.ViewModelProviders;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.frame.entity.Article;
import com.frame.library.base.BaseListFragment;
import com.just.agentweb.LogUtils;

public class Fragment1 extends BaseListFragment<Article.DatasBean, Fragment1VM> {

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Override
    protected void onItemClick(Article.DatasBean item) {
        Main2Activity.start(context,item.getLink());
        Log.e("clickurl", "onItemClick: "+item.getLink() );
    }

    @Override
    protected BaseQuickAdapter<Article.DatasBean, BaseViewHolder> getAdapter() {
        return new ArticleAdapter(R.layout.item_atcitle);
    }

    @Override
    protected void requestData() {
        viewModel.getData(pageIndex).observe(this, new ListObserver());
    }

    @Override
    protected Fragment1VM createViewModel() {
        return ViewModelProviders.of(this).get(Fragment1VM.class);
    }

}
