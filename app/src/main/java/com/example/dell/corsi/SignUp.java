package com.example.dell.corsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                sinleton  = Sinleton.getAdmin(userName.getText().toString(),password.getText().toString());

                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
