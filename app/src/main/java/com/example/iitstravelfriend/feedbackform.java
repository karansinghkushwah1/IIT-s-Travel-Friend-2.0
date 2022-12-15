package com.example.iitstravelfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

//this class is used to create the feedback form
public class feedbackform extends AppCompatActivity {
private Firebase Ref;                   //Firebase is used to store the data collected by user feedback into database
EditText username,feedback;             //Edittext for writing the feedback and username


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackform);
        username = findViewById(R.id.Username);
        feedback = findViewById(R.id.writefeedback);
        //Below code is used to specify the location where you want to store data
        Firebase.setAndroidContext(this);
        //This link is generated in Firebase to store data
        Ref = new Firebase("https://iit-s-travel-friend-default-rtdb.firebaseio.com/");

    }

    public void sendfeedback(View view) {
        String usernameinput = username.getText().toString();
        String feedbackinput = feedback.getText().toString();
        //Constraints are used here
        Firebase Reusername = Ref.child("Username");
        Reusername.setValue(usernameinput);
        Firebase Reffeedback = Ref.child("Feedback");
        Reffeedback.setValue(feedbackinput);
        if(TextUtils.isEmpty(usernameinput)){
            username.setError("User Name is required.");
            return;
        }
        if(TextUtils.isEmpty(feedbackinput)){
            feedback.setError("Feedback is required.");
            return;
        }
        Toast.makeText(feedbackform.this, "Your response is recorded", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), frontpage.class));
        finish();
    }
}