package com.example.a1sessiontest.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1sessiontest.Network.Networking;
import com.example.a1sessiontest.Network.authPOJO;
import com.example.a1sessiontest.R;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener
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
        reg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), RegActivity.class));
            }
        });

        auth.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Boolean isEmpty = login.getText().toString().isEmpty() || password.getText().toString().isEmpty();

        if(isEmpty)
        {
            Toast.makeText(this, "Enter in all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Networking.getInstance().apIrequests().registration(new authPOJO(login.getText().toString(), password.getText().toString())).enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response)
                {
                    Log.e("432", response.body().toString());
                    if(response.body().toString().contains("token"))
                    {
                        Toast.makeText(AuthActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                    else if(response.body().toString().contains("active"))
                    {
                        Toast.makeText(AuthActivity.this, "User in system!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(AuthActivity.this, "Invalid login or password!", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t)
                {
                    Toast.makeText(AuthActivity.this, "Check internet connection", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
