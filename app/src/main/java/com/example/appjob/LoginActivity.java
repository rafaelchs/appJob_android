package com.example.appjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnCreate;
    private Button btnLogin;
    private EditText txtEmail;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        txtPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    public void onClick_createAccount(View v){

        Intent intent = new Intent(LoginActivity.this,accountActivity.class);
        startActivity(intent);

    }

    public void onClick_login(View v){


        if(txtEmail.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()){

            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();

        }else{

            Toast.makeText(LoginActivity.this, "There are incomplete fields", Toast.LENGTH_SHORT).show();
        }



    }
}
