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
// This class is made for register page . There , we used FirebaseAuth to store the user data
public class register extends AppCompatActivity {
    EditText mFullName,mEmail,mPassword, mCpassword;                //Buttons for user info
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;                                             //FirebaseAuth for login and registring future
    //ProgressBar progressBar;
//    SharedPreferences sharedPreferences;
//
//    public static final String filename = "login";
//    public static final String Username = "username";
//    public static final String Password = "password";

    //IF you want to use progressBar then uncomment the above line and code written below
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //There giving id to buttons that we created in layout
        mFullName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email1);
        mPassword = findViewById(R.id.password);
        mCpassword = findViewById(R.id.confirmpasswordb);
        mRegisterBtn = findViewById(R.id.registerbutton);
        mLoginBtn  = findViewById(R.id.alreadyregister);

//        sharedPreferences = getSharedPreferences(filename, Context.MODE_PRIVATE);
//        if(sharedPreferences.contains(Username)){
//            Intent i = new Intent(register.this, MainActivity.class);
//            startActivity(i);
//        }

        fAuth = FirebaseAuth.getInstance();
        //progressBar = findViewById(R.id.progressBar);

//        if(fAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//
//        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = mFullName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();                  //create string for email, password and for confirm password
                String password = mPassword.getText().toString().trim();
                String cpassword = mCpassword.getText().toString().trim();
                //Below we give constraints for email, password and confirm password. This will helps to reduce false registration
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
                if(!password.equals(cpassword)){
                    mPassword.setError("Password mismatch.");
                    return;
                }

                //progressBar.setVisibility(View.VISIBLE);
                //There we use firebase Auth to store email and password of users in our database
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString(Username, fullname);
//                            editor.putString(Password, password);
//                            editor.commit();

                            Toast.makeText(register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),frontpage.class));
                            finish();
                            
                        }else {
                            Toast.makeText(register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        //Create a button for log in is user is already register before
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),login.class));
                finish();

            }
        });
    }
}