package com.example.nonhlanhla.sanlamskyapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nonhlanhla.sanlamskyapp.R;

public class VendActivity extends AppCompatActivity {

    ImageView iv_MTN, iv_VODA, iv_CELLC, iv_TELKOM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vend);


        iv_MTN = findViewById(R.id.iv_MTN);
        iv_VODA = findViewById(R.id.iv_VODA);
        iv_CELLC = findViewById(R.id.iv_CELLC);
        iv_TELKOM = findViewById(R.id.iv_TELKOM);




        iv_MTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Mtn.class);
                startActivity(intent);
            }
        });

        iv_VODA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Voda.class);
                startActivity(intent);
            }
        });

        iv_CELLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CellC.class);
                startActivity(intent);
            }
        });

        iv_TELKOM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Telkom.class);
                startActivity(intent);
            }
        });
    }
}
