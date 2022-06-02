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


public class  WorkersInfoFragment extends Fragment {
   public EditText f1;
   public TextView srm;
   public Button b1,b2;
    public String s;
    public FirebaseUser user;
    public int k;
    public FirebaseAuth firebaseAuth;
    public DatabaseReference db2,s2,s3;

    public WorkersInfoFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_workers, container, false);
        db2=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/");
         f1=rootView.findViewById(R.id.skr);
         b1=rootView.findViewById(R.id.skr1);
         srm=rootView.findViewById(R.id.skk);
        s2=db2.child("issues");
        s3=db2.child("issuecount");
        firebaseAuth = FirebaseAuth.getInstance();
         b2=rootView.findViewById(R.id.hsk);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=f1.getText().toString();
                 user = firebaseAuth.getCurrentUser();


                s3.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String xyz = dataSnapshot.getValue(String.class);
                        k = Integer.parseInt(xyz) + 1;
                        String l=String.valueOf(k);
                        String hk="issue"+l;
                        s3.setValue(l);
                        String uid=user.getUid();
                        Issues post = new Issues(s,uid,hk);
                        Map<String,Object> postVa = post.toMap();
                        Map<String, Object> childUpdates = new HashMap<>();
                        childUpdates.put("/issues/"+hk+"/", postVa);

                        db2.updateChildren(childUpdates);
                        srm.setText("problem has been submitted successfully");

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        srm.setText("problem has not been submitted successfully");

                    }
                });




            }});
            b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();

                startActivity(new Intent(getActivity(), MainActivity.class));

            }});




                return rootView;

    }
}
