package com.example.android.colony;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    public  EditText email2, flatno2, mobile2, retype2, password2, userid2, name2;
     public Button submit2;
    public String email3, flatno3, mobile3, retype3, password3, userid3, name3;
    public FirebaseAuth firebaseAuth;
     public FirebaseUser firebaseUser;
     public DatabaseReference db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=FirebaseDatabase.getInstance().getReferenceFromUrl("https://colony-447ed.firebaseio.com/");
        firebaseAuth=FirebaseAuth.getInstance();
        email2 = findViewById(R.id.email1);
        flatno2 = findViewById(R.id.flatno1);
        mobile2 = findViewById(R.id.mobile1);
        retype2 = findViewById(R.id.retype1);
        password2 = findViewById(R.id.password1);
        userid2 = findViewById(R.id.userid1);
        submit2 = findViewById(R.id.submit1);
        name2 = findViewById(R.id.name1);

        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){

                    String  user_userid = userid2.getText().toString().trim();
                     String user_password = password2.getText().toString().trim();
                     String repass=retype2.getText().toString().trim();
                     if(repass.equals(user_password))
                     {

                    firebaseAuth.createUserWithEmailAndPassword(user_userid,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();


                                register();

                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });}
                }

            }
        });


    }
    private Boolean validate(){
        Boolean result = false;
        email3 = email2.getText().toString();
        flatno3 = flatno2.getText().toString();
        mobile3 = mobile2.getText().toString();
        retype3 = retype2.getText().toString();
        password3 = password2.getText().toString();
        userid3 = userid2.getText().toString();
        name3 = name2.getText().toString();


            if (password3.isEmpty() || email3.isEmpty() || flatno3.isEmpty() || mobile3.isEmpty() || retype3.isEmpty() || userid3.isEmpty() || name3.isEmpty()) {
                Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
            }
        else {
            result = true;
        }

        return result;
    }

 public void register(){
     String user_emaili = email2.getText().toString().trim();
     String user_flatnoi = flatno2.getText().toString().trim();
     String  user_mobilei = mobile2.getText().toString().trim();
     String  user_useridi = userid2.getText().toString().trim();
     String user_namei = name2.getText().toString().trim();
     firebaseUser=firebaseAuth.getCurrentUser();
     String key=firebaseUser.getUid();
     Users post = new Users(user_emaili,user_flatnoi,user_mobilei,user_namei,user_useridi,key);
     Map<String,Object> postVa = post.toMap();
     Map<String, Object> childUpdates = new HashMap<>();
     childUpdates.put("/users/"+key+"/", postVa);
     Toast.makeText(RegisterActivity.this, "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();
     db.updateChildren(childUpdates);
     finish();
     startActivity(new Intent(RegisterActivity.this,MainActivity.class));
 }

}