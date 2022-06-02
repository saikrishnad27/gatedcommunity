package com.example.android.colony;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class third extends AppCompatActivity {
    TextView text1,text5,text3,text4,text6,text7;
    DatabaseReference db1,sr,sr1;
    String lm,lmn,lmno,lmnop,mno;
    String i;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        db1=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/");


        Bundle extras=getIntent().getExtras();
        i=extras.getString("name");
        lmnop=extras.getString("key");
        mno=extras.getString("email");
        lm=extras.getString("id");
        lmn=extras.getString("flatno");
        lmno=extras.getString("mobile");
        text1=findViewById(R.id.skr9);
        text1.setText("id:"+lm);
        text1=findViewById(R.id.skr10);
        text1.setText("email:"+mno);
        text1=findViewById(R.id.skr11);
        text1.setText("name:"+i);

        text5=findViewById(R.id.skr8);
        text5.setText("flatno:"+lmn);
        text3=findViewById(R.id.skr7);
        text3.setText("mobile:"+lmno);
        text4=findViewById(R.id.skr4);
        text6=findViewById(R.id.skr6);
        text7=findViewById(R.id.skr5);
        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text4.setText("user registered");
                sr = db1.child("RegisteredAccounts");
                sr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        RegUsers pos = new RegUsers(mno,lmn,lmno,i, lm, lmnop);
                        Map<String, Object> postValue = pos.toMap();


                        Map<String, Object> childUpdates = new HashMap<>();
                        childUpdates.put("/RegisteredAccounts/"+lmnop+"/", postValue);

                        db1.updateChildren(childUpdates);
                        sr1=db1.child("users");
                        sr1.child(lmnop).removeValue();
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }            });

        text7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text4.setText("user rejected");
                sr1=db1.child("users");
                sr1.child(lmnop).removeValue();
            }});
    }



}


