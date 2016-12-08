package com.jzbwlkj.recycleview;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private List<String> list;
    private LinearLayout ll1;
    private List<Integer> integers;
    private ListView listView1;
    private ListView listView2;
    private SharedPreferences sp;
    //默认的时候为0;如果不默认值得话会出现异常
    private int position = 0;
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        list = new ArrayList<>();
        //模拟数据这里大概模拟了60个
        for (int i = 0; i < 60; i++) {
            list.add("nihao" + i);
        }
        //第一个listview
        listView1 = (ListView) findViewById(R.id.lv_main3_1);
        //第二个
        listView2 = (ListView) findViewById(R.id.lv_main3_2);
        //通过sp获取到存储的数据
        sp = getSharedPreferences("Item", MODE_PRIVATE);
        //默认返回的数据为-1.如果你想每次都锁定第一个.可以改变postion的值为1
        position = sp.getInt("position", 0);
        //设置适配器
        myListAdapter = new MyListAdapter(list, this);
        listView1.setAdapter(myListAdapter);
        listView2.setAdapter(new MyListAdapter(list, this));
        //添加条目点击事件
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //记录老的位置
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_main3_item);
                linearLayout.setBackgroundColor(Color.WHITE);
                //如果当前位置没有点击的话就记录当前的view,并将当前的位置保存到sp中
                if (position != 0 && position != i) {
                    //表示当前点击的位置没有记录,将颜色给清空
                    MyApplication.oldView.setBackgroundResource(0);
                }
                //保存当前的view.为了以后删除该view的颜色使用
                MyApplication.oldView = view;

                if (position == 0) {
                    myListAdapter.notifyDataSetChanged();

                }
                //将当前的点击位置保存,同时position需要记录当前的位置
                position = i;
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("position", i);
                editor.commit();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //每次都会将第一个位置保存到sp中
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("position", 0);
        editor.commit();
    }
}
