package com.jzbwlkj.recycleview;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 作者：admin on 2016/12/6 15:33
 */

public class ThreeAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ThreeAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    public ThreeAdapter(List<String> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.tv_main3,s);
    }
}
