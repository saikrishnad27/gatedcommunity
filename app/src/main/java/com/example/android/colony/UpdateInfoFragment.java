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

public class UpdateInfoFragment extends Fragment {
    public DatabaseReference mno;

    WorkerAdapter Adapter;
    ListView listView;
    public UpdateInfoFragment() {}
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_update_info, container, false);

        listView = rootView.findViewById(R.id.list123);
       final  ArrayList<Worker> WorkersList=new ArrayList<>();




        mno = FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/").child("workers");

        mno.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Worker worker = ds.getValue(Worker.class);
                    WorkersList.add(worker);
                }
            }



            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
        Adapter = new WorkerAdapter(getActivity(), WorkersList);

        listView.setAdapter(Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Worker denton = WorkersList.get(position);
                Intent intent = new Intent(getActivity(), five.class);
                intent.putExtra("name", denton.getname());
                intent.putExtra("job", denton.getjob());
                intent.putExtra("phno", denton.getphno());
                intent.putExtra("id",denton.getid());

                startActivity(intent);
            }
        });


        return rootView;


    }
}
