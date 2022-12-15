package com.example.iitstravelfriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
// This class is made for login activity . There , we used FirebaseAuth to store the user data
public class login extends AppCompatActivity {
    EditText mEmail,mPassword;                              //Buttons for user info
    Button mLoginBtn;
    TextView mCreateBtn;
    FirebaseAuth fAuth;                                     //FirebaseAuth for login and registring future

//    SharedPreferences sharedPreferences;
//
//    public static final String filename = "login";
//    public static final String Username = "username";
//    public static final String Password = "password";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //There giving id to buttons that we created in layout
        mEmail = findViewById(R.id.email1);
        mPassword = findViewById(R.id.password);
        mLoginBtn = findViewById(R.id.loginbutton);
        mCreateBtn  = findViewById(R.id.alreadylogin);

//        sharedPreferences = getSharedPreferences(filename, Context.MODE_PRIVATE);
//        if(sharedPreferences.contains(Username)){
//            Intent i = new Intent(login.this, frontpage.class);
//            startActivity(i);
//        }

        fAuth = FirebaseAuth.getInstance();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();                          //create string for email, password
                String password = mPassword.getText().toString().trim();
                //Below we give constraints for email, password. This will helps to reduce false registration
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required.");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters.");
                    return;
                }
                //There we use firebase Auth to store email and password of users in our database
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString(Username, email);
//                            editor.putString(Password, password);
//                            editor.commit();

                            Toast.makeText(login.this, "Login is successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),frontpage.class));
                            finish();

                        }else {
                            Toast.makeText(login.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        //Create a button for register activity , if  user is new
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),register.class));
                finish();

            }
        });
    }
}