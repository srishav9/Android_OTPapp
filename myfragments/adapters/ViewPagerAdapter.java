package com.example.risha.myfragments.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by risha on 30-Dec-17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private  List<Fragment> mFragmentList=new ArrayList<>();
    private  List<String> mFragmentTitleList=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    //fragment aayega is list me add hoga amd getItem call hoke deta jaayega
    public void addFragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    //isko ctrl Space maarke lana hai.
    @Override
    public CharSequence getPageTitle(int position) {

        return mFragmentTitleList.get(position);
    }
}
