package com.example.nonhlanhla.sanlamskyapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nonhlanhla.sanlamskyapp.BalanceEnquiryActivity;
import com.example.nonhlanhla.sanlamskyapp.R;


public class LandingsScreen extends AppCompatActivity {

    Button btn_Vend_Airtime, btn_Balance_Enquiry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landings_screen);


        btn_Vend_Airtime = findViewById(R.id.btn_Vend_Airtime);
        btn_Balance_Enquiry = findViewById(R.id.btn_Balance_Enquiry);
//        btn_Log_in = findViewById(R.id.btn_Log_in);


        btn_Vend_Airtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), VendActivity.class);
                startActivity(intent);
            }
        });

        btn_Balance_Enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(), BalanceEnquiryActivity.class);
                startActivity(intent);

            }
        });

//        btn_Log_in.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent (getApplicationContext(), VendActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }
}
