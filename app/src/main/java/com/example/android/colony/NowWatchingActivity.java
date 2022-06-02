package com.example.android.colony;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NowWatchingActivity extends AppCompatActivity {
   public TextView text1,text4,text6,text7;
  public  DatabaseReference db2,sr,db1;
   public String lm,lmn,lmno,lmnop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_watching);
        Bundle extras=getIntent().getExtras();
        lm=extras.getString("uid");

        db2=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/RegisteredAccounts");
        db1=db2.child(lm);

        lmnop=extras.getString("number");
        lmn=extras.getString("matter");
        lmno=extras.getString("place");
        text1=findViewById(R.id.first);
        text1.setText(lmn);
        text4=findViewById(R.id.second);
        text4.setText("place:"+lmno);
        text6=findViewById(R.id.three);
        text7=findViewById(R.id.three1);


        sr = db1.child("announcement");
        text6.setText(" Delete the Announcement");


        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                sr.child(lmnop).removeValue();
                text7.setText("Announcement deleted successfully");
            }});
    }



}