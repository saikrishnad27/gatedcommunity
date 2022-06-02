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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class  IssuesFragment extends Fragment {
    DatabaseReference db,db1,db2,db3,db4,db5;

    FirebaseAuth firebaseAuth;
     public FirebaseUser user;
   public Button b1;
   TextView txr2;
    public EditText e1;
    int k;

   public String s,hk,xyz,yx;

    public IssuesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_issues, container, false);

        db = FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/");
        e1=rootView.findViewById(R.id.chint);
        txr2=rootView.findViewById(R.id.txt24);

        b1=rootView.findViewById(R.id.chin);
        db1=db.child("plumberissues");
        firebaseAuth=FirebaseAuth.getInstance();
          user=firebaseAuth.getCurrentUser();
        hk=user.getUid();
        db2=db.child("RegisteredAccounts").child(hk);
        db3=db2.child("name");
        db3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 xyz=dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        db4=db.child("hwcount");
        db4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                yx=dataSnapshot.getValue(String.class);
                  k = Integer.parseInt(yx)+1;
                yx = String.valueOf(k);
                db4.setValue(yx);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s=e1.getText().toString();
                yx = "issue"+yx;
                plumb post = new plumb(s, xyz, yx);
                Map<String, Object> postVa = post.toMap();
                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/plumberissues/" + yx + "/", postVa);
                txr2.setText("SUBMITTED SUCCESSFULLY");

                db.updateChildren(childUpdates);

            }
        });






        return rootView;

    }
}
