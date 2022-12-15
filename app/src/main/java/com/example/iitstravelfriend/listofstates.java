package com.example.iitstravelfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//This class is used when user clicked on second button
//There we used list view feature to make list of elements and then display them on next page
public class listofstates extends AppCompatActivity {
    ListView listView;
    String listofiitname[] = {"Chhattisgarh","Odisha","Maharashtra","Delhi","Jharkhand","Karnataka","Gujarat","Goa","Assam","Telangana","Madhya Pradesh","Jammu  and  Kashmir","Rajasthan","Uttar Pradesh (Kanpur)","West Bengal","Tamil Nadu","Himachal Pradesh","Kerala","Bihar","Uttarakhand","Punjab","Andhra Pradesh","Uttar Pradesh (Varanasi)"};

    String listofrailwaystation[] = {"Name - Raipur Junction" + "\n" + "Pincode - 492009" + "\n" + "Distance from IIT - 12km","Name - Khurda Road Junction" + "\n" + "Pincode - 752050" + "\n" + "Distance from IIT - 8km", "Name - Kanjur Marg station" + "\n" + "Pincode - 400078" + "\n" + "Distance from IIT - 1.8km","Name - New Delhi Railway station" +"\n" + "Pincode - 110002" + "\n" + "Distance from IIT - 14km","Name - Dhanbad Railway station" + "\n" + "Pincode - 826001" + "\n" + "Distance from IIT - 3km","Name - Dharwad Railway station" + "\n" + "Pincode - 580001" + "\n" + "Distance from IIT - 15km","Name - Ahmedabad Railway station" + "\n" + "Pincode - 380002" + "\n" + "Distance from IIT - 28km","Name - Madgoan Railway station" + "\n" + "Pincode - 403601" + "\n" + "Distance from IIT - 24km","Name - Guwahati Railway station" + "\n" + "Pincode - 781001" + "\n" + "Distance from IIT - 22km","Name - Lingampalli station" + "\n" + "Pincode - 500019" + "\n" + "Distance from IIT - 25km","Name - indore Railway station" + "\n" + "Pincode - 452001" + "\n" + "Distance from IIT - 24km","Name - Jammu Tawi Railway station" + "\n" + "Pincode - 180012" + "\n" + "Distance from IIT - 20km","Name - Jodhpur Railway station" + "\n" + "Pincode - 342001" + "\n" + "Distance from IIT - 25km","Name - Kanpur central" + "\n" + "Pincode - 208003" + "\n" + "Distance from IIT - 15km","Name - Kharagpur Railway station" + "\n" + "Pincode - 721101" + "\n" + "Distance from IIT - 5km","Name - Chennai Central" + "\n" + "Pincode - 600003" + "\n" + "Distance from IIT - 14km","Name - Joginder Nagar" + "\n" + "Pincode - 175015" + "\n" + "Distance from IIT - 54km","Name - Palakkad Railway station" + "\n" + "Pincode - 678002" + "\n" + "Distance from IIT - 25km","Name - Bihta Railway station" + "\n" + "Pincode - 801103" + "\n" + "Distance from IIT - 2km","Name - Roorkee Railway station" + "\n" + "Pincode - 247667" + "\n" + "Distance from IIT - 3.4km","Name - Rupnagar Railway station" + "\n" + "Pincode - 140001" + "\n" + "Distance from IIT - 2km","Name - Renigunta Junction" + "\n" + "Pincode - 517501" + "\n" + "Distance from IIT - 15km","Name - Varanasi Cantt" + "\n" + "Pincode - 221002" + "\n" + "Distance from IIT - 10km"};

    String listofairport[] = {"Name - Sawmi Vivekananda Airport" + "\n" + "Pincode - 492015" + "\n" + "Distance from IIT - 15km","Name - Biju Pattanaik Airport" + "\n" + "Pincode - 751020" + "\n" + "Distance from IIT - 35km","Name - Chatrapati Shivaji Airport" + "\n" + "Pincode - 400099" + "\n" + "Distance from IIT - 10km","Name - Indira Gandhi Airport" + "\n" + "Pincode - 110037" + "\n" + "Distance from IIT - 10km","Name - Subhash Chandra Bose Airport" + "\n" + "Pincode - 700053" + "\n" + "Distance from IIT - 250km","Name - Hubbali Airport" + "\n" + "Pincode - 580030" + "\n" + "Distance from IIT - 10km","Name - Ahmedabad Airport" + "\n" + "Pincode - 380003" + "\n" + "Distance from IIT - 22km","Name - Goa Airport" + "\n" + "Pincode - 403801" + "\n" + "Distance from IIT - 38km","Name - Guwahati Airport" + "\n" + "Pincode - 781015" + "\n" + "Distance from IIT - 23km","Name - Rajiv Gandhi Airport" + "\n" + "Pincode - 500409" + "\n" + "Distance from IIT - 60km","Name - Indore Airport" + "\n" + "Pincode - 453112" + "\n" + "Distance from IIT - 31km","Name - Jammu Airport" + "\n" + "Pincode - 180003" + "\n" + "Distance from IIT - 18km","Name - Jodhpur Airport" + "\n" + "Pincode - 342011" + "\n" + "Distance from IIT - 28km","Name - Lucknow Airport" + "\n" + "Pincode - 226009" + "\n" + "Distance from IIT - 95km","Name - Subhash Chandra Bose Airport" + "\n" + "Pincode - 700052" + "\n" + "Distance from IIT - 140km","Name - Chennai Airport" + "\n" + "Pincode - 600027" + "\n" + "Distance from IIT - 13km","Name - Bhuntar Airport" + "\n" + "Pincode - 175125" + "\n" + "Distance from IIT - 60km","Name - Coimbatore Airport" + "\n" + "Pincode - 641014" + "\n" + "Distance from IIT - 50km", "Name - Jai Prakash Narayan Airport" + "\n" + "Pincode - 800014" + "\n" + "Distance from IIT - 32km","Name - Jolly Grank Airport" + "\n" + "Pincode - 248143" + "\n" + "Distance from IIT - 68km","Name - Chandigarh Airport" + "\n" + "Pincode - 140306" + "\n" + "Distance from IIT - 51km","Name - Tirupati Airport" + "\n" + "Pincode - 517520" + "\n" + "Distance from IIT - 12km","Name - Babatpur Airport" + "\n" + "Pincode - 221006" + "\n" + "Distance from IIT - 31km"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofstates);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //Create a list view below for state name list
        listView = findViewById(R.id.statevielistname);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listofiitname);
        listView.setAdapter(ad);
        //below code will display the result on the edittext view provided
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(listofstates.this, Addressbyiitname.class  );
                i.putExtra("railwaystationinfo",listofrailwaystation[position]);
                i.putExtra("flightinfo",listofairport[position]);
                startActivity(i);

            }
        });
    }
}