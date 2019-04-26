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
import com.example.appjob.model.RestObj;
import com.example.appjob.model.Person;
import com.example.appjob.retrofitRemote.APIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnCreate;
    private Button btnLogin;
    private EditText txtEmail;
    private EditText txtPassword;
    private PersonService personService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        txtPassword = (EditText) findViewById(R.id.editTextPassword);

        personService = APIUtils.getUserService();
    }

    public void onClick_createAccount(View v){

        Intent intent = new Intent(LoginActivity.this,accountActivity.class);
        startActivity(intent);

    }

    public void onClick_login(View v){


        if(txtEmail.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()){


        }else{

            Toast.makeText(LoginActivity.this, "There are incomplete fields", Toast.LENGTH_SHORT).show();
        }



    }

    public void login(String email, String password){

        Call call = personService.login(email,password);
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(retrofit2.Call call, Response response) {

                if (response.isSuccessful()){

                    RestObj obj = (RestObj) response.body();

                   if (obj.getMessage().equals(true)){


                       Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                       startActivity(intent);
                       finish();

                   }else{

                   }
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {

                Log.e("ERROR: ", t.getMessage());
            }
        });

    }
}
