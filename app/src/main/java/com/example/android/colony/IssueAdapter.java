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

public class IssueAdapter extends ArrayAdapter<aissues> {
    public IssueAdapter(Activity context, ArrayList<aissues> aissues) {
        super(context, 0, aissues);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.newissues, parent, false);
        }
        aissues fu = getItem(position);
        TextView tw = (TextView) listItemView.findViewById(R.id.skm2);
        assert fu != null;
        tw.setText(fu.getissue());
        return listItemView;
    }
}




