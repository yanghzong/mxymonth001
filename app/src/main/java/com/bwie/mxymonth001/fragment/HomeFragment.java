package com.bwie.mxymonth001.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.mxymonth001.R;
import com.bwie.mxymonth001.adapter.NewsAdapter;
import com.bwie.mxymonth001.bean.News;
import com.bwie.mxymonth001.mvp.presenter.HomePresenter;
import com.bwie.mxymonth001.mvp.view.HomeView;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class HomeFragment extends Fragment implements HomeView {
    private RecyclerView rv;
    private StaggeredGridLayoutManager manager;
    private HomePresenter presenter;
    private NewsAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        rv = v.findViewById(R.id.rv_home);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        presenter = new HomePresenter();
        presenter.attach(this);
        presenter.getNews("http://www.zhaoapi.cn/product/getCarts?uid=71");
        manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(manager );
    }

    @Override
    public void getNews(News news) {
        if (news!=null){
            adapter = new NewsAdapter(getContext(),news.getData());
            rv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
