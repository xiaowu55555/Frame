package com.frame.frame;


import com.frame.frame.entity.Article;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppService {
    String BASE_URL = "http://www.wanandroid.com/";

    //    //获取首页banner
//    @GET("banner/json")
//    Observable<HttpResult<List<HomeBanner>>> getBanner();
//获取首页文章列表
    @GET("article/list/{pageIndex}/json")
    Observable<HttpResult<Article>> getArticleList(@Path("pageIndex") int pageIndex);
}
