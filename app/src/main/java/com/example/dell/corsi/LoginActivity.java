package com.example.dell.corsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    TextView userName;
    TextView password;
    Sinleton sinleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.login_btn);
        userName = (TextView) findViewById(R.id.user_name_tv);
        password = (TextView) findViewById(R.id.password_tv);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sinleton  = Sinleton.getAdmin(userName.getText().toString(),password.getText().toString());


                if (sinleton.getmName().equals(sinleton.getnName())&& sinleton.getmPassword().equals(sinleton.getnPassword()))
                {
                    Intent i = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this,"You are not the admin !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
