package com.example.android.colony;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class plumber extends AppCompatActivity {

    public DatabaseReference mno;
    Aplumber aplumber;
    PlumberAdapter mnp;
    ListView listView;

    ArrayList<Aplumber> PlumbersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);
        PlumbersList = new ArrayList<>();





        listView= findViewById(R.id.list11);

        mno = FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/").child("plumberissues");

        mno.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    aplumber = ds.getValue(Aplumber.class);
                    PlumbersList.add(aplumber);
                }
            }


            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
        mnp = new PlumberAdapter(plumber.this, PlumbersList);

        listView.setAdapter(mnp);

    }}
