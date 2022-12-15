package com.example.iitstravelfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class frontpage extends AppCompatActivity {
    Button Searchbutton1;                   //two buttons are made here for search purposes
    Button Searchbutton2;

//    SharedPreferences sharedPreferences;
//    TextView tvmessage;
//    public static final String filename = "login";
//    public static final String Username = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        tvmessage = findViewById(R.id.tvmessage);
        Searchbutton1 = findViewById(R.id.searchbutton1); //calling the buttons from layout
        Searchbutton2 = findViewById(R.id.searchbutton2);
        //Define the condition for user when they choose the first option or another
        //SEtonclicklistener is used for this purpose

//        sharedPreferences = getSharedPreferences(filename, Context.MODE_PRIVATE);
//        if(sharedPreferences.contains(Username))
//            tvmessage.setText("Hi "+ sharedPreferences.getString(Username, ""));

        Searchbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),listofiits.class));        //startactivity is used to jump to other page(there , it is redirected to listofiitss page
            }
        });
        Searchbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),listofstates.class));
            }
        });
    }

    public void givefeedback(View view) {
        startActivity(new Intent(getApplicationContext(), feedbackform.class));
        finish();
    }
}