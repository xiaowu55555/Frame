package com.frame.library.net;


import com.frame.library.entity.Article;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String BASE_URL = "http://www.wanandroid.com/";

    //    //获取首页banner
//    @GET("banner/json")
//    Observable<HttpResult<List<HomeBanner>>> getBanner();
//获取首页文章列表
    @GET("article/list/{pageIndex}/json")
    Observable<HttpResult<Article>> getArticleList(@Path("pageIndex") int pageIndex);
}
