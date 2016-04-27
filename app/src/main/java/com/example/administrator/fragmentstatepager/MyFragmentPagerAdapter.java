package com.example.administrator.fragmentstatepager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/29.
 */
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragmentsList;
    public MyFragmentPagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragmentsList) {
        super(supportFragmentManager);
        this.fragmentsList=fragmentsList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentsList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
