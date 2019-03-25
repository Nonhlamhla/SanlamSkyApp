package com.example.nonhlanhla.sanlamskyapp.Activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nonhlanhla.sanlamskyapp.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;


public class Login extends AppCompatActivity {

    private EditText ed_cell_Number, ed_pin_Number;
    private TextView btn_SignUp, txt_ForgotPW;
    private Button btn_Login;
    private CheckBox checkbox;

    private Socket socket;
    private String socketIP = "196.31.118.146";
    private int iPN = 3110;
    private static final Logger logger = Logger.getLogger(Login.class.getName());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Thread thr = new Thread(new Server());
        thr.start();

        ed_cell_Number = findViewById(R.id.ed_cell_Number);
        ed_pin_Number = findViewById(R.id.ed_pin_Number);
        btn_SignUp = findViewById(R.id.btn_SignUp);
        txt_ForgotPW = findViewById(R.id.txt_ForgotPW);
        btn_Login = findViewById(R.id.btn_Login);
        checkbox = findViewById(R.id.checkbox);

        //SHOWS AND HIDES USER PASSWORD
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
                if (value)
                {
                    // Show Password
                    ed_pin_Number.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                    // Hide Password
                    ed_pin_Number.setTransformationMethod(PasswordTransformationMethod.getInstance());
                {
                }
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logInfo(ed_cell_Number.getText().toString(), ed_pin_Number.getText().toString());
            }
        });

//    private void validation(String pin_Number, String cell_Number) {
//        if ((pin_Number.equals("1234")) && (cell_Number.equals("1234"))) {
//            Intent intent = new Intent(Login.this, LandingsScreen.class);
//            startActivity(intent);
//        } else {
//            counter--;
//            Toast.makeText(getApplicationContext(), "No of login attempts remaining: " + String.valueOf(counter), Toast.LENGTH_SHORT).show();
//
//            if (counter == 0) {
//                btn_Login.setEnabled(false);
//            }
//        }
//    }
    }

    private void logInfo(String username, String password) {

        Connect c = new Connect();

        if (username.equals(c.getUsername()) && password.equals(c.getPassword())) {
            logger.info("Welcome, " + username);
            Toast.makeText(getApplicationContext(), "Welcome, " + username, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),LandingsScreen.class);
            startActivity(intent);
        } else {
            logger.info("Login Failed");
            Toast.makeText(getApplicationContext(), "Login Failed ", Toast.LENGTH_SHORT).show();
        }
    }

    public class Server implements Runnable {
        public void run(){

                try {
                    logger.info("Sockets connections");
                    socket = new Socket(socketIP, iPN);
                    BufferedReader input;
                    PrintWriter output;

                    //CHECKS IS SERVER CONNECTION IS ESTABLISHED OR NOT
                    if (socket.isConnected()) {
                        logger.info("Connected");
                    }
                    if (!socket.isConnected()) {
                        logger.info("Not Connected");
                    }

                    //open buffered reader for reading data from client
                    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String username = input.readLine();
                    System.out.println("SERVER SIDE" + username);
                    String password = input.readLine();
                    System.out.println("SERVER SIDE" + password);

                    //open printwriter for writing data to client
                    output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                    output.flush();
                    output.close();

                    socket.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
    }

     class Connect {
        //CLASS THAT GETS USER INPUTS "PASSWORD & CELL NUMBER
            private String CELLNUMBER = "java";
            private String PASSWORD = "java";

            public String getUsername() {
                return this.CELLNUMBER;
            }

            public String getPassword() {
                return this.PASSWORD;
            }
        }
    }









