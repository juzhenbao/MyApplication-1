package com.jzbwlkj.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：admin on 2016/12/6 14:21
 */

public class SecondAdapter extends RecyclerView.Adapter <SecondAdapter.SelfHolder>{
    List<String> list;
    Main3Activity activity ;

    public SecondAdapter(List<String> list, Main3Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public SelfHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = View.inflate(activity,R.layout.item_main3,null);
        return new SelfHolder(view);
    }

    @Override
    public void onBindViewHolder(SecondAdapter.SelfHolder holder, int position) {
              holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SelfHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public SelfHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_main3);
        }
    }
}
