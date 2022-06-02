package com.example.android.colony;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;



public class AnnouncementFragment extends Fragment {

    public String uid;
    public DatabaseReference db,db1,db2;
    ListView listView;
    WordAdapter Adapter;

    public AnnouncementFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        listView = rootView.findViewById(R.id.list);
        final ArrayList<Word> WordsList=new ArrayList<>();
        FirebaseAuth firebaseAuth;
        FirebaseUser user1;


        firebaseAuth = FirebaseAuth.getInstance();
        user1= firebaseAuth.getCurrentUser();



        uid=user1.getUid();

        db = FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/").child("RegisteredAccounts");
        db1=db.child(uid);
        db2=db1.child("announcement");
        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {

                   Word word = ds.getValue(Word.class);
                    WordsList.add(word);
                   }
            }



            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
       Adapter = new WordAdapter(getActivity(), WordsList);
        listView.setAdapter(Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word denton = WordsList.get(position);
                Intent intent = new Intent(getActivity(), NowWatchingActivity.class);
                intent.putExtra("uid",uid);
                intent.putExtra("number", denton.getnumber());
                intent.putExtra("matter", denton.getmatter());
                intent.putExtra("place", denton.getplace());
                startActivity(intent);
            }
        });


        return rootView;

    }
}
