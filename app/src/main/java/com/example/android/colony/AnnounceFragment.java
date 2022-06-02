package com.example.android.colony;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class AnnounceFragment extends Fragment {

    DatabaseReference db,db1,db2,db3;
    int k;
    TextView tt1;
    Button b1;
    EditText e1,e2;

    String s,hk,xyz,yx;

    public AnnounceFragment() {}
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_announce, container, false);
            tt1 = rootView.findViewById(R.id.txt2);
            e2=rootView.findViewById(R.id.txt5);
            db = FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/");
            db1 = db.child("RegisteredAccounts");
            db2 = db.child("announcementcount");

            b1 = rootView.findViewById(R.id.bt3);
            e1 = rootView.findViewById(R.id.txt1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                             xyz = dataSnapshot.getValue(String.class);
                            k = Integer.parseInt(xyz) + 1;
                            String l = String.valueOf(k);
                             hk = "announcement" + l;
                            db2.setValue(l);
                            s = e1.getText().toString();
                            yx=e2.getText().toString();
                            db1.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot ds : snapshot.getChildren()) {

                                        String key= ds.child("key").getValue(String.class);
                                        Announcements post = new Announcements(s, hk,yx);
                                        Map<String, Object> postVa = post.toMap();

                                        Map<String, Object> childUpdates = new HashMap<>();
                                        childUpdates.put( key+"/announcement/"+ hk +
                                                "/", postVa);

                                        db1.updateChildren(childUpdates);
                                        tt1.setText("Announcement has been made successfully");

                                    }
                                }



                                @Override

                                public void onCancelled(DatabaseError firebaseError) {

                                }
                            });

                         }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            tt1.setText("Announcement has not done");

                        }
                    });


                }
            });




            return rootView;


    }

}

