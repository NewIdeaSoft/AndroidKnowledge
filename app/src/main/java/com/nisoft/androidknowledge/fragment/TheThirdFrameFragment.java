package com.nisoft.androidknowledge.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.nisoft.androidknowledge.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/13.
 */

public class TheThirdFrameFragment extends BaseFragment {
    @Override
    protected View initView() {
        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText("第三方");
        textView.setTextColor(Color.RED);
        textView.setTextSize(24);
        return textView;
    }
}
