package com.example.appjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appjob.model.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class accountActivity extends AppCompatActivity {

    private Button btnCreate;
    private Button btnBack;
    private EditText txtName, txtLastName, txtPhone, txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnCreate = (Button) findViewById(R.id.btnSave);
        btnBack = (Button) findViewById(R.id.btnBack);
        txtName = (EditText) findViewById(R.id.editTextName);
        txtLastName = (EditText) findViewById(R.id.editTextLastname);
        txtPhone = (EditText) findViewById(R.id.editTextPhone_number);
        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        txtPassword = (EditText) findViewById(R.id.editTextPassword);

    }

    public void onClick_save(View v){

        if (txtName.getText().toString().isEmpty() || txtLastName.getText().toString().isEmpty() ||
        txtPhone.getText().toString().isEmpty() || txtEmail.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()){

            Toast.makeText(accountActivity.this, "There are incomplete fields", Toast.LENGTH_SHORT).show();

        }else{

            Intent intent = new Intent(accountActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }


    }

    public void onClick_back(View v){

        Intent intent = new Intent(accountActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();

    }

    public void add_person(){


       /* Call<Person> call = petService.insert_pet(objPet);
        call.enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {

                if (response.isSuccessful()){

                    Toast.makeText(MainActivity.this, "Added successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {

                Log.e("ERROR: ", t.getMessage());
            }
        });*/

    }
}
