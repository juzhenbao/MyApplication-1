package com.jzbwlkj.recycleview;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：admin on 2016/12/6 16:59
 */

public class MyListAdapter extends BaseAdapter {
    private List<String> list ;
    private Activity activity ;
   private SharedPreferences sp;
    public MyListAdapter(List<String> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
           view  = View.inflate(activity,R.layout.item_main3,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //获取到sp中的数值
        sp = activity.getSharedPreferences("Item", activity.MODE_PRIVATE);
        int position = sp.getInt("position", 0);
        //判断当前的位置是不是点击的位置
        System.out.println("position" + position);
        //判断当前的位置是否是当前的位置.如果是当前位置就改变颜色,否则不变
        if(position == i){
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        }else{
            holder.linearLayout.setBackgroundResource(0);
        }
        holder.textView.setText(list.get(i));
        return view;
    }
//定义一个holder
    class ViewHolder {
        TextView textView;
        LinearLayout linearLayout;
        public ViewHolder(View view ) {
            this.linearLayout = (LinearLayout) view.findViewById(R.id.ll_main3_item);
            this.textView = (TextView) view.findViewById(R.id.tv_main3);
        }
    }
}
