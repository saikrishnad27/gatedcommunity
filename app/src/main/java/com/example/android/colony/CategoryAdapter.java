package com.example.android.colony;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AnnouncementFragment();
        } else
            if(position==1)
            return new EmergencyFragment();
        else
            if(position==2)
                return new IssuesFragment();
        else
            if(position==3)
                return new WorkersInfoFragment();
        else return new PaymentFragment()           ;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.announce);
        } else if(position==1) {
            return mContext.getString(R.string.emergency);
        }
        else if(position==2)
        { return  mContext.getString(R.string.issues);}
        else if(position==3)
        { return mContext.getString(R.string.works);}
        else
            return mContext.getString(R.string.payment);

    }
}