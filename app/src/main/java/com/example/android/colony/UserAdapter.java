package com.example.android.colony;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Activity context, ArrayList<User> User) {
        super(context, 0, User);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.newuserlist, parent, false);
        }
        User fu = getItem(position);
        TextView tw = (TextView) listItemView.findViewById(R.id.skm);
        assert fu != null;
        tw.setText(fu.getname());
        TextView tw1 = (TextView) listItemView.findViewById(R.id.skm1);
        tw1.setText(fu.getmobile());
        return listItemView;
    }
}



