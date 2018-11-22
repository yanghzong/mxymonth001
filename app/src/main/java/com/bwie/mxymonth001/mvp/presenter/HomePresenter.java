package com.bwie.mxymonth001.mvp.presenter;

import com.bwie.mxymonth001.bean.News;
import com.bwie.mxymonth001.inter.ICallBack;
import com.bwie.mxymonth001.mvp.model.Model;
import com.bwie.mxymonth001.mvp.view.HomeView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class HomePresenter {
    private HomeView hv;
    private Model model;
    public void attach(HomeView hv){
        this.hv = hv;
        model = new Model();
    }
    public void detach(){
        if (hv!=null){
            hv = null;
        }
    }

    public void getNews(String url){
        Type type = new TypeToken<News>(){}.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void success(Object o) {
                News news = (News) o;
                hv.getNews(news);
            }

            @Override
            public void failed(Exception e) {

            }
        },type);

    }
}
