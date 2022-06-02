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

public class WorkerAdapter extends ArrayAdapter<Worker> {
    public WorkerAdapter(Activity context, ArrayList<Worker> Worker) {
        super(context, 0, Worker);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.updateworkers, parent, false);
        }
        Worker fu = getItem(position);
        TextView tw = (TextView) listItemView.findViewById(R.id.srm123);
        assert fu != null;
        tw.setText(fu.getname());
        TextView tw1 = (TextView) listItemView.findViewById(R.id.srm12);
        tw1.setText(fu.getjob());
        TextView tw12 = (TextView) listItemView.findViewById(R.id.srm1);
        tw12.setText(fu.getphno());

        return listItemView;
    }
}




