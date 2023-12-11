package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}