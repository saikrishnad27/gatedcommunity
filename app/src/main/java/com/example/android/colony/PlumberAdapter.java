package com.example.android.colony;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


    public class PlumberAdapter extends ArrayAdapter<Aplumber> {
        private Context mcontext;
        private ArrayList<Aplumber> PlumbersList= new ArrayList<Aplumber>();
        public PlumberAdapter(Context context,ArrayList<Aplumber> list){
            super(context,0,list);
            mcontext=context;
            PlumbersList=list;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItem=convertView;
            if(listItem==null)
                listItem= LayoutInflater.from(mcontext).inflate(R.layout.six,parent,false);
            Aplumber currentActor=PlumbersList.get(position);


            TextView id=(TextView) listItem.findViewById(R.id.srh) ;
            id.setText("Descrition:"+currentActor.getdescription());

            TextView name=(TextView) listItem.findViewById(R.id.srh1 );
            name.setText("Given by:"+currentActor.getname());

            return listItem;
        }

    }




