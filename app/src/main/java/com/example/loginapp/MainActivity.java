package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void btnLogin_Clicked(View v){
        Intent i = new Intent(this, LoginScreen.class);
        startActivity(i);
    }
    public void btnRegister_Clicked(View v){
        Intent i = new Intent(this, RegiserScreen.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginRef",MODE_PRIVATE);

        Boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false);

        super.onCreate(savedInstanceState);
        if(isLoggedIn)
            startActivity(new Intent(this, LogOutScreen.class));
        else
            setContentView(R.layout.activity_main);
    }
}