package com.example.android.colony;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class EmergencyFragment extends Fragment {
    TextView t1,t2,t3,t4,t5,t6;
    public String s1,s2;
    DatabaseReference db,db1,db2,db3;

    public EmergencyFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.activity_emergency, container, false);
        db=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/workers");
        t1=rootView.findViewById(R.id.shi1);
        t2=rootView.findViewById(R.id.shi2);
        t3=rootView.findViewById(R.id.shi4);
        t4=rootView.findViewById(R.id.shi5);
        t5=rootView.findViewById(R.id.shi7);
        t6=rootView.findViewById(R.id.shi8);
        db1=db.child("worker1");
        db1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                    s1= snapshot.child("name").getValue(String.class);
                    t1.setText(s1);
                    s2= snapshot.child("job").getValue(String.class);
                    t2.setText(s2);


            }



            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });

        db2=db.child("worker2");
        db2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    s1= snapshot.child("name").getValue(String.class);
                    t3.setText(s1);
                    s2= snapshot.child("job").getValue(String.class);
                    t4.setText(s2);

                }




            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });

        db3=db.child("worker3");
        db3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                    s1= snapshot.child("name").getValue(String.class);
                    t5.setText(s1);
                    s2= snapshot.child("job").getValue(String.class);
                    t6.setText(s2);


            }



            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });




        return rootView;

    }

}
