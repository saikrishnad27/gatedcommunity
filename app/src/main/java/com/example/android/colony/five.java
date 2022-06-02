package com.example.android.colony;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class five extends AppCompatActivity {
    EditText text1,text5,text3;
    DatabaseReference db1,sr;
    String lm,lmn,lmno,lmnop;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        db1=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/");


        Bundle extras=getIntent().getExtras();

        lm=extras.getString("id");
        text1=findViewById(R.id.nam1);
        text5=findViewById(R.id.passwor1);
        text3=findViewById(R.id.job1);


        b2=findViewById(R.id.submit12);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lmn=text1.getText().toString();
                lmno=text5.getText().toString();
                lmnop=text3.getText().toString();

                sr = db1.child("workers").child(lm);
                sr.child("name").setValue(lmn);
                sr.child("phno").setValue(lmno);
                sr.child("job").setValue(lmnop);
            }});


    }
}
