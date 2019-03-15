package com.frame.frame;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.library.entity.Article;

import java.util.List;

public class ArticleAdapter extends BaseQuickAdapter<Article.DatasBean, BaseViewHolder> {
    public ArticleAdapter(int layoutResId, @Nullable List<Article.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Article.DatasBean item) {
        helper.setText(R.id.tv_title,item.getTitle());
    }
}
