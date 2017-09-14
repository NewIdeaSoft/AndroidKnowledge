package com.nisoft.androidknowledge;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.nisoft.androidknowledge.base.BaseFragment;
import com.nisoft.androidknowledge.fragment.CustermViewFragment;
import com.nisoft.androidknowledge.fragment.OtherKnowledgeFrament;
import com.nisoft.androidknowledge.fragment.TheThirdFrameFragment;
import com.nisoft.androidknowledge.fragment.UsefulFrameFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RadioGroup mRadioGroup;
    private ViewPager mViewPager;
    private List<BaseFragment> mFragments;
    private PagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        initializeFragments();
        FragmentManager fm = getSupportFragmentManager();
        mAdapter = new FragmentStatePagerAdapter(fm){
            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }
        };
        mViewPager.setAdapter(mAdapter);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.useful_frame:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.the_third:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.custom_view:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.other:
                        mViewPager.setCurrentItem(3);
                        break;
                    default:
                        break;
                }
            }
        });
        mRadioGroup.check(R.id.useful_frame);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRadioGroup.check(R.id.useful_frame);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.the_third);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.custom_view);
                        break;
                    case 3:
                        mRadioGroup.check(R.id.other);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initializeFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new UsefulFrameFragment());
        mFragments.add(new TheThirdFrameFragment());
        mFragments.add(new CustermViewFragment());
        mFragments.add(new OtherKnowledgeFrament());
    }
}
