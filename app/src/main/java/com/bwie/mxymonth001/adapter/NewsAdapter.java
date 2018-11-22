package com.bwie.mxymonth001.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.mxymonth001.R;
import com.bwie.mxymonth001.bean.News;
import com.bwie.mxymonth001.utils.StringUtils;

import java.util.List;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<News.DataBean> list;

    public NewsAdapter(Context context, List<News.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context,R.layout.item_news,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<News.DataBean.ListBean> listBeanList = this.list.get(position).getList();
        if (listBeanList.size()>0){
            News.DataBean.ListBean listBean = listBeanList.get(0);
            String images = listBean.getImages();
            String[] split = images.split("\\|");
            holder.txtTitle.setText(listBean.getTitle());
            Glide.with(context).load(StringUtils.https2http(split[0])).into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            img = itemView.findViewById(R.id.img);
        }
    }
}
