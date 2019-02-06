package com.example.nonhlanhla.sanlamskyapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nonhlanhla.sanlamskyapp.R;

import java.util.Arrays;
import java.util.List;



public class Voda extends AppCompatActivity {

    Spinner voda_Spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voda);

        voda_Spinner = findViewById(R.id.voda_Spinner);

        List<String> simpleList = Arrays.asList(getResources().getStringArray(R.array.voda_items));


        ArrayAdapter<String> simpleAdapter = new ArrayAdapter<>(Voda.this, R.layout.support_simple_spinner_dropdown_item,simpleList);
        voda_Spinner.setAdapter(simpleAdapter);




        voda_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        Toast.makeText(getApplicationContext(), "Make Your Selection", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        Intent intent = new Intent(Voda.this, VodaVend_1.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "Selected item 0", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(getApplicationContext(), "Selected item 1", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(getApplicationContext(), "Selected item 2", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(getApplicationContext(), "Selected item 3", Toast.LENGTH_SHORT).show();
                        break;

                    case 5:
                        Toast.makeText(getApplicationContext(), "Selected item 4", Toast.LENGTH_SHORT).show();
                        break;

                    case 6:
                        Toast.makeText(getApplicationContext(), "Selected item 5", Toast.LENGTH_SHORT).show();
                        break;


                    case 7:
                        Toast.makeText(getApplicationContext(), "Selected item 6", Toast.LENGTH_SHORT).show();
                        break;

                    case 8:
                        Toast.makeText(getApplicationContext(), "Selected item 7", Toast.LENGTH_SHORT).show();
                        break;

                    case 9:
                        Toast.makeText(getApplicationContext(), "Selected item 8", Toast.LENGTH_SHORT).show();
                        break;

                    case 10:
                        Toast.makeText(getApplicationContext(), "Selected item 9", Toast.LENGTH_SHORT).show();
                        break;

                    case 11:
                        Toast.makeText(getApplicationContext(), "Selected item 10", Toast.LENGTH_SHORT).show();
                        break;

                    case 12:
                        Toast.makeText(getApplicationContext(), "Selected item 11", Toast.LENGTH_SHORT).show();
                        break;

                    case 13:
                        Toast.makeText(getApplicationContext(), "Selected item 12", Toast.LENGTH_SHORT).show();
                        break;

                    case 14:
                        Toast.makeText(getApplicationContext(), "Selected item 13", Toast.LENGTH_SHORT).show();
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



