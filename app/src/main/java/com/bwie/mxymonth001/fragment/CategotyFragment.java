package com.bwie.mxymonth001.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mxymonth001.R;
import com.bwie.mxymonth001.adapter.CateChildAdapter;
import com.bwie.mxymonth001.adapter.CateGroupAdapter;
import com.bwie.mxymonth001.bean.CategotyChild;
import com.bwie.mxymonth001.bean.CategotyGroup;
import com.bwie.mxymonth001.mvp.presenter.CatePresenter;
import com.bwie.mxymonth001.mvp.view.CateView;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class CategotyFragment extends Fragment implements CateView {
    private RecyclerView rvGroup;
    private LinearLayout lv;
    private CatePresenter presenter;
    private CateGroupAdapter groupAdapter;
    private CateChildAdapter childAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cate,container,false);
        rvGroup = v.findViewById(R.id.rv_cate_group);
        lv = v.findViewById(R.id.lv);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        presenter = new CatePresenter();
        presenter.attach(this);
        presenter.getGroup("http://www.zhaoapi.cn/product/getCatagory");
        presenter.getChild("http://www.zhaoapi.cn/product/getProductCatagory?cid=1");
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvGroup.setLayoutManager(manager);


    }

    @Override
    public void getGroup(CategotyGroup categotyGroup) {
        if (categotyGroup!=null){
            groupAdapter = new CateGroupAdapter(getContext(),categotyGroup.getData());
            rvGroup.setAdapter(groupAdapter);
            groupAdapter.notifyDataSetChanged();
            groupAdapter.setOnClickListener(new CateGroupAdapter.OnClickListener() {
                @Override
                public void click(int cid) {
                    presenter.getChild("http://www.zhaoapi.cn/product/getProductCatagory?cid="+cid);
                }
            });
        }
    }

    @Override
    public void getChild(CategotyChild categotyChild) {
        if (categotyChild!=null){
            lv.removeAllViews();
            for (CategotyChild.DataBean dataBean : categotyChild.getData()) {
                TextView textView = new TextView(getContext());
                textView.setText(dataBean.getName());
                textView.setPadding(50,20,0,20);
                RecyclerView recyclerView = new RecyclerView(getContext());
                GridLayoutManager manager = new GridLayoutManager(getContext(),3);
                recyclerView.setLayoutManager(manager);
                childAdapter = new CateChildAdapter(getContext(),dataBean.getList());
                recyclerView.setAdapter(childAdapter);
                childAdapter.notifyDataSetChanged();
                lv.addView(textView);
                lv.addView(recyclerView);
            }

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
