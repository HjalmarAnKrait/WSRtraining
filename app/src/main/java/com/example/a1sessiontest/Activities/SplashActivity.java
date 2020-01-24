package com.example.a1sessiontest.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getSharedPreferences("settings", Context.MODE_PRIVATE).getBoolean("isFirstLaunch", true))
        {
            startActivity(new Intent(this, FirstSetupActivity.class));
            finish();
        }
        else
        {
            startActivity(new Intent(this, AuthActivity.class));
            finish();
        }
    }
}
