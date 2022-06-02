package com.example.android.colony;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Category1Adapter extends FragmentPagerAdapter {
    private Context mContext;

    public Category1Adapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AnnounceFragment();
        } else
        if(position==1)
            return new NewUsersFragment();
        else
        if(position==2)
            return new UserIssuesFragment();
        else
            return new UpdateInfoFragment();

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.announce);
        } else if(position==1) {
            return mContext.getString(R.string.newusers);
        }
        else if(position==2)
        { return  mContext.getString(R.string.userissues);}
        else return mContext.getString(R.string.updation);


    }



}
