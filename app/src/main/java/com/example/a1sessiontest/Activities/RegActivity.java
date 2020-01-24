package com.example.a1sessiontest.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1sessiontest.Network.Networking;
import com.example.a1sessiontest.Network.regPOJO;
import com.example.a1sessiontest.R;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button   reg, back;
    private EditText login, email, password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        reg = findViewById(R.id.regButton);
        back = findViewById(R.id.backButton);

        login = findViewById(R.id.loginText);
        email = findViewById(R.id.emailText);
        password1 = findViewById(R.id.passwordText1);
        password2 = findViewById(R.id.passwordText2);

        reg.setOnClickListener(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        back.setText(Html.fromHtml("<u>Back</u>"));
    }

    @Override
    public void onClick(View v)
    {
        Boolean isEmpty = login.getText().toString().isEmpty() ||
                email.getText().toString().isEmpty() || password1.getText().toString().isEmpty() || password2.getText().toString().isEmpty();
        Boolean isHaveSobaka = email.getText().toString().contains("@");
        Boolean isEqualsPasswords = password1.getText().toString().equals(password2.getText().toString());

        if(isEmpty)
        {
            Toast.makeText(this, "Enter in all fields!", Toast.LENGTH_SHORT).show();
        }
        else if(!isHaveSobaka)
        {
            Toast.makeText(this, "Email must contains @!", Toast.LENGTH_SHORT).show();
        }
        else if(!isEqualsPasswords)
        {
            Toast.makeText(this, "Passwords are not equal!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Networking.getInstance().apIrequests().authorization(new regPOJO(login.getText().toString(),
                    email.getText().toString(), password1.getText().toString(), 150, 150)).enqueue(new Callback<JsonElement>()
            {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response)
                {
                    Log.e("432", "Server response - " + response.body().toString());
                    if(response.body().toString().contains("Success"))
                    {
                        Toast.makeText(RegActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(RegActivity.this, "An error while creating account", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t)
                {
                    Toast.makeText(RegActivity.this, "Check internet", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
