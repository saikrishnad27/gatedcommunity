package com.example.android.colony;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public Button b,b1,b2;
    public EditText userName, userPassword;
    public String  userids,  passwordp;
    public Intent intent;
    public FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(MainActivity.this, UserActivity.class));
        }
        userName=findViewById(R.id.editText);
        userPassword=findViewById(R.id.editText2);

        b = findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userids=userName.getText().toString().trim();
                passwordp=userPassword.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(userids, passwordp).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                             intent = new Intent(MainActivity.this, UserActivity.class);
                            startActivity(intent);


                        }else{
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                        }
                    }

                });



            }
        });
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userids=userName.getText().toString().trim();
                passwordp=userPassword.getText().toString().trim();

                if(userids.equals("admin")&&passwordp.equals("admin")){

                    intent=new Intent(MainActivity.this,AdminActivity.class);
                startActivity(intent);}
                if(userids.equals("plumber")&&passwordp.equals("plumber")){

                    intent=new Intent(MainActivity.this,plumber.class);
                    startActivity(intent);}



            }
        });

    }
}
