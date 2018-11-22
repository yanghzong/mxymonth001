package com.bwie.mxymonth001.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.mxymonth001.R;
import com.bwie.mxymonth001.bean.CategotyGroup;

import java.util.List;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class CateGroupAdapter extends RecyclerView.Adapter<CateGroupAdapter.ViewHolder> {
    private Context context;
    private List<CategotyGroup.DataBean> list;


    public CateGroupAdapter(Context context, List<CategotyGroup.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.item_cate_group,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtTitle.setText(list.get(position).getName()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(list.get(position).getCid());
            }
        });
    }

    public interface OnClickListener {
        void click(int cid);
    }

    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
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
        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
