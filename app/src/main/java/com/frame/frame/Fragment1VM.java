package com.frame.frame;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.frame.frame.entity.Article;
import com.frame.library.base.BaseViewModel;
import com.frame.library.net.RxSubscriber;
import com.frame.library.net.RxTransformer;

import java.util.List;

public class Fragment1VM extends BaseViewModel {
    public Fragment1VM(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Article.DatasBean>> getData(int page) {
        MutableLiveData<List<Article.DatasBean>> data = new MutableLiveData<>();
        App.getInstance().getApi().getArticleList(page)
                .compose(RxTransformer.applySchedulers())
                .subscribe(new RxSubscriber<Article>(this) {
                    @Override
                    public void onSuccess(Article article) {
                        data.setValue(article.getDatas());
                    }

                    @Override
                    public void onFailed(Throwable e) {
                        showError(e.getMessage());
                    }
                });
        return data;
    }
}
