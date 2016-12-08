package com.jzbwlkj.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < 10;i++){
            list.add(i+",,,,");
        }
        Log.i("Mainactivity", list.size()+"");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        recyclerView.setAdapter(new MyAdapter(R.layout.item_main,list));
    }
}
