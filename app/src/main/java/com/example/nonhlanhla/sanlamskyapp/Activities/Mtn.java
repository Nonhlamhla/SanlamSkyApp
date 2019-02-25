package com.example.nonhlanhla.sanlamskyapp.Activities;


import android.annotation.TargetApi;
import android.content.Intent;
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
    private String s;


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtn);

        /**
         * Implements Runnable Thread
         */
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
                    switch (position) {

                        case 0:
//                        Toast.makeText(getApplicationContext(), "Make Your Selection", Toast.LENGTH_SHORT).show();
                            break;

                        case 1:

                            /**
                             * CALLING CLASS TO MAIN METHOED
                             */

                            ServerConnection serverConnection = new ServerConnection();
                            try {
                                s = serverConnection.sendData("Hi VS17188N00794|18300", "Hi VS17188N00794|18300".length());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


//                        Toast.makeText(getApplicationContext(), "Selected item 0", Toast.LENGTH_SHORT).show();
                            break;

                        case 2:
                            Intent intent = new Intent(Mtn.this, MtnVend_1.class);
                            startActivity(intent);
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







