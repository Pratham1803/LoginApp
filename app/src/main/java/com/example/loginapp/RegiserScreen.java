package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegiserScreen extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText txtEmailId;
    EditText txtPsw;
    public void btnRegister_Clicked(View v){
        String emailId = txtEmailId.getText().toString();
        String psw = txtPsw.getText().toString();
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(emailId, psw)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        Toast.makeText(RegiserScreen.this, task.toString(), Toast.LENGTH_SHORT).show();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(RegiserScreen.this, LoginScreen.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegiserScreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiser_screen);

        txtEmailId = findViewById(R.id.txtEmailId);
        txtPsw = findViewById(R.id.txtPsw);
    }
}