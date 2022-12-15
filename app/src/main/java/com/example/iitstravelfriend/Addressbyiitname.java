package com.example.iitstravelfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
//this class is used to display the final results to user
public class Addressbyiitname extends AppCompatActivity {
    TextView railwayinfo;
    TextView airportinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addressbyiitname);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        railwayinfo = findViewById(R.id.railwayinfo);
        airportinfo = findViewById(R.id.airportinfo);
        //here we define the textview where we want the result
        railwayinfo.setText(getIntent().getExtras().getString("railwaystationinfo"));
        airportinfo.setText(getIntent().getExtras().getString("flightinfo"));
    }
    //This button is used for sign - out purpose. It will redirected the user to log in page
    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }
}