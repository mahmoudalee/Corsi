package com.example.dell.corsi.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.corsi.R;
import com.example.dell.corsi.model.Sinleton;

public class SignUp extends AppCompatActivity {
    Button signButton;
    TextView userName;
    TextView password;
    Sinleton sinleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signButton = (Button) findViewById(R.id.sign_btn);
        userName = (TextView) findViewById(R.id.user_name_sign_tv);
        password = (TextView) findViewById(R.id.password_sign_tv);

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!userName.getText().toString().equals("") && !password.getText().toString().equals(""))
                {
                    sinleton  = Sinleton.getAdmin(userName.getText().toString(),password.getText().toString());

                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignUp.this,"You have to enter a correct data",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
