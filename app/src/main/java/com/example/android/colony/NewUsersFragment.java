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


public class NewUsersFragment extends Fragment {
    public ListView listView;

    UserAdapter Adapter;
   public DatabaseReference mno;

    public NewUsersFragment() {}
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_new_users, container, false);
       final ArrayList<User> UsersList=new ArrayList<>();



        listView = rootView.findViewById(R.id.list1);

        mno = FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/").child("users");

        mno.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                  User  user = ds.getValue(User.class);
                    UsersList.add(user);
                }
                }



            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
        Adapter = new UserAdapter(getActivity(), UsersList);

        listView.setAdapter(Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User denton = UsersList.get(position);
                Intent intent = new Intent(getActivity(), third.class);
                intent.putExtra("name", denton.getname());
                intent.putExtra("email", denton.getemail());
                intent.putExtra("flatno", denton.getflatno());
                intent.putExtra("id",denton.getid());
                intent.putExtra("mobile",denton.getmobile());
                intent.putExtra("key",denton.getkey());

                startActivity(intent);
            }
        });




        return rootView;


    }
}
