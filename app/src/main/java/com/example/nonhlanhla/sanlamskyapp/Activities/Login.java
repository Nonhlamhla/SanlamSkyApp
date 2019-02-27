package com.example.nonhlanhla.sanlamskyapp.Activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nonhlanhla.sanlamskyapp.R;


public class Login extends AppCompatActivity {

    EditText ed_cell_Number, ed_pin_Number;
    TextView btn_SignUp, txt_ForgotPW;
    Button btn_Login;
    String pin_Number, cell_Number;
    ImageView imageView2;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_cell_Number = findViewById(R.id.ed_cell_Number);
        ed_pin_Number = findViewById(R.id.ed_pin_Number);
        btn_SignUp = findViewById(R.id.btn_SignUp);
        txt_ForgotPW = findViewById(R.id.txt_ForgotPW);
        btn_Login = findViewById(R.id.btn_Login);
        imageView2 = findViewById(R.id.imageView2);

        Toast.makeText(getApplicationContext(), "No of login attempts remaining: 5 " + String.valueOf(counter), Toast.LENGTH_SHORT).show();


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation(ed_cell_Number.getText().toString(), ed_pin_Number.getText().toString());
            }
        });
    }

    private void validation(String pin_Number, String cell_Number) {
        if ((pin_Number.equals("1234")) && (cell_Number.equals("1234"))) {
            Intent intent = new Intent(Login.this, LandingsScreen.class);
            startActivity(intent);
        } else {
            counter--;
            Toast.makeText(getApplicationContext(), "No of login attempts remaining: " + String.valueOf(counter), Toast.LENGTH_SHORT).show();

            if (counter == 0) {
                btn_Login.setEnabled(false);
            }
        }
    }
}



