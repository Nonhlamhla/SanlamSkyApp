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

import com.example.nonhlanhla.sanlamskyapp.R;


public class Login extends AppCompatActivity {

    EditText ed_cell_Number, ed_pin_Number;
    TextView btn_SignUp, txt_ForgotPW;
    Button btn_Login;
    String cell_Number, pin_Number;
    ImageView imageView2;

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


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Acitivity Intent
                 */
//                Intent intent = new Intent(getApplication(), LandingsScreen.class);
//                startActivity(intent);


                /** Validation of Edittexts
                 */

                cell_Number = ed_cell_Number.getText().toString();


                if (TextUtils.isEmpty(cell_Number) && TextUtils.isEmpty(pin_Number)) {
                    ed_cell_Number.setError("Cell Number ");
                    ed_pin_Number.setError("Pin Number");
                }

                else if (cell_Number != null) {
                    Intent i = new Intent(Login.this, LandingsScreen.class);
                    startActivity(i);
                }

                else if (pin_Number != null){
                    Intent i = new Intent(Login.this, LandingsScreen.class);
                    startActivity(i);
                }

            }
        });
    }
}



