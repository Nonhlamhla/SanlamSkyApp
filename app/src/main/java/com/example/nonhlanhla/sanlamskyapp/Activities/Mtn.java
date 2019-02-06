package com.example.nonhlanhla.sanlamskyapp.Activities;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nonhlanhla.sanlamskyapp.Pojo.ServerConnection;
import com.example.nonhlanhla.sanlamskyapp.R;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Mtn extends AppCompatActivity {

    Spinner mtn_Spinner;
    Thread t;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtn);


        //IMPLEMENTS SERVER
        t = new Thread(new ServerConnection());
        t.start();

        mtn_Spinner = findViewById(R.id.mtn_Spinner);

        List<String> simpleList = Arrays.asList(getResources().getStringArray(R.array.mtn_items));

        ArrayAdapter<String> simpleAdapter = new ArrayAdapter<>(Mtn.this, R.layout.support_simple_spinner_dropdown_item, simpleList);
        mtn_Spinner.setAdapter(simpleAdapter);

        mtn_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent i;

                switch (position) {

                    case 0:
                        Toast.makeText(getApplicationContext(), "Make Your Selection", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:

                        ServerConnection serverConnection = new ServerConnection();
                        try {
                            serverConnection.sendData("Airtime mtn5|2|1234|U|20111214|004528|0|");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        Toast.makeText(getApplicationContext(), "Selected item 0", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:

                        Toast.makeText(getApplicationContext(), "Selected item 1", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(getApplicationContext(), "Selected item 2", Toast.LENGTH_SHORT).show();
                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    }





