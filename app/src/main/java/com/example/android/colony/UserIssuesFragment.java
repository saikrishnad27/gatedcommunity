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
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class UserIssuesFragment extends Fragment {
public DatabaseReference mno;
public    ListView listView;

    IssueAdapter Adapter;

    public UserIssuesFragment() {}
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users_issues, container, false);
        final  ArrayList<aissues> IssuesList=new ArrayList<>();


        listView = rootView.findViewById(R.id.list12);

        mno = FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/").child("issues");

        mno.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                   aissues user = ds.getValue(aissues.class);
                    IssuesList.add(user);
                }
            }



            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
        Adapter = new IssueAdapter(getActivity(), IssuesList);

        listView.setAdapter(Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                aissues denton = IssuesList.get(position);
                Intent intent = new Intent(getActivity(), four.class);
                intent.putExtra("id", denton.getuid());
                intent.putExtra("issue", denton.getissue());
                intent.putExtra("issueno", denton.getissueno());
                startActivity(intent);
            }
        });




        return rootView;


    }
}
