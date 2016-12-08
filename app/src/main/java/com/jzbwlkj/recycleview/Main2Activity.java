package com.jzbwlkj.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list = new ArrayList<>();
        for(int i =0 ; i < 40 ; i++){
            list.add("nihao"+i);
        }
////设置布局管理器
//        mRecyclerView.setLayoutManager(layout);
////设置adapter
//        mRecyclerView.setAdapter(adapter)
////设置Item增加、移除动画
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
////添加分割线
////        mRecyclerView.addItemDecoration(new DividerItemDecoration(
////                getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
//        recyclerView.setAdapter(new MyAdapter(R.layout.item_main,list));
        MyAdapter myAdapter = new MyAdapter(R.layout.item_main, list);
        recyclerView.setAdapter(myAdapter);
        myAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        myAdapter.isFirstOnly(false);
    }
}
