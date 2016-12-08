package com.jzbwlkj.recycleview;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
/**
 * 作者：admin on 2016/12/6 11:24
 */

 class MyAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

    public MyAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        System.out.println("jinru");
        baseViewHolder.setText(R.id.tv_main,s);
    }
}
