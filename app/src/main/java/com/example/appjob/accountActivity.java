package com.example.appjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appjob.iRetrofit.PersonService;
import com.example.appjob.model.Person;
import com.example.appjob.retrofitRemote.APIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class accountActivity extends AppCompatActivity {

    private Button btnCreate;
    private Button btnBack;
    private EditText txtName, txtLastName, txtPhone, txtEmail, txtPassword;
    public PersonService pService;


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

        pService = APIUtils.getUserService();

    }

    public void onClick_save(View v){

        if (txtName.getText().toString().isEmpty() || txtLastName.getText().toString().isEmpty() ||
        txtPhone.getText().toString().isEmpty() || txtEmail.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()){

            Toast.makeText(accountActivity.this, "There are incomplete fields", Toast.LENGTH_SHORT).show();

        }else{

            Person obj = new Person();
            obj.setName(txtName.getText().toString());
            obj.setLastname(txtLastName.getText().toString());
            obj.setPhone_number(Integer.valueOf(txtPhone.getText().toString()));
            obj.setEmail(txtEmail.getText().toString());
            obj.setPassword(txtPassword.getText().toString());

            add_person(obj);

            Intent intent = new Intent(accountActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }


    }

    public void onClick_back(View v){

        Intent intent = new Intent(accountActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();

    }

    public void add_person(Person objPerson){


        Call<Person> call = pService.insert_person(objPerson);
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {

                if (response.isSuccessful()){

                    Toast.makeText(accountActivity.this, "Added successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {

                Log.e("ERROR: ", t.getMessage());
            }
        });

    }
}
