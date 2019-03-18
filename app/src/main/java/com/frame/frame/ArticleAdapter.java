package com.frame.frame;

import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.frame.entity.Article;

public class ArticleAdapter extends BaseQuickAdapter<Article.DatasBean, BaseViewHolder> {
    public ArticleAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Article.DatasBean item) {
        helper.setText(R.id.tv_title, Html.fromHtml(item.getTitle()));
    }
}
