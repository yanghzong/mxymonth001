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
import com.bwie.mxymonth001.bean.CategotyChild;

import java.util.List;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class CateChildAdapter extends RecyclerView.Adapter<CateChildAdapter.ViewHolder> {
    private Context context;
    private List<CategotyChild.DataBean.ListBean> list;

    public CateChildAdapter(Context context, List<CategotyChild.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.item_cate_child,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position).getName()+"");
        Glide.with(context).load(list.get(position).getIcon()).into(holder.img);
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
