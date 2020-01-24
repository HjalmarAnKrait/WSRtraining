package com.example.a1sessiontest.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1sessiontest.R;

public class AuthActivity extends AppCompatActivity
{
    private Button auth, reg, skip;
    private EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        auth = findViewById(R.id.authButton);
        reg = findViewById(R.id.regButton);
        skip = findViewById(R.id.skipButton);
        login = findViewById(R.id.loginText);
        password = findViewById(R.id.passwordText);

        skip.setText(Html.fromHtml("<u>Skip</u>"));
        reg.setText(Html.fromHtml("<u>Sign up</u>"));

    }
}
