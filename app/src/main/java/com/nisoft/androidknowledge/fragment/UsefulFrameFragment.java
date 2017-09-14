package com.nisoft.androidknowledge.fragment;

import android.view.View;
import android.widget.ListView;

import com.nisoft.androidknowledge.R;
import com.nisoft.androidknowledge.adapter.UsefulFrameListAdapter;
import com.nisoft.androidknowledge.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/13.
 */

public class UsefulFrameFragment extends BaseFragment {
    private String [] mDatas;

    private ListView mListView;
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_useful_frame,null);
        mListView = (ListView) view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    protected void setData() {
        mDatas = new String[]{"OKHttp",
                "xUtils3","Retrofit2","Fresco",
                "Glide","greenDao","RxJava",
                "volley","Gson","FastJson",
                "picasso","evenBus","jcvideoplayer",
                "pulltorefresh","Expandablelistview","UniversalVideoView",
                "....."};
        UsefulFrameListAdapter adapter = new UsefulFrameListAdapter(mContext,mDatas);
        mListView.setAdapter(adapter);
    }
}
