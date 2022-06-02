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

public class four extends AppCompatActivity {
    TextView text1,text4,text6,text7;
    DatabaseReference db1,db2,sr;
    String lm,lmn,lmno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);



        Bundle extras=getIntent().getExtras();

        db2=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/").child("issues");

        lm=extras.getString("id");
        lmn=extras.getString("issue");
        lmno=extras.getString("issueno");
        text1=findViewById(R.id.skr19);
        text1.setText("issue:"+lmn);
        text4=findViewById(R.id.skr16);
        text6=findViewById(R.id.skr17);
        text7=findViewById(R.id.skr18);
        db1=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/RegisteredAccounts").child(lm);

                sr = db1.child("name");
                sr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String xyz=dataSnapshot.getValue(String.class);
                        text7.setText("reported by:"+xyz);

                        }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
         text6.setText("If solved Delete the issue");


        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text4.setText("isssue removed successfully");

                db2.child(lmno).removeValue();
            }});
    }



}



