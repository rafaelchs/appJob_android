package com.example.appjob.iRetrofit;

import com.example.appjob.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PersonService {


    @POST("/add")
    Call<Person> insert_person(@Body Person objPet);

    @GET("/show")
    Call<List<Person>>list();

    @DELETE("/delete/{id}")
    Call<Person>delete_person(@Path("id") int id);

    @PUT("/update/{id}")
    Call<Person>update_person(@Path("id") int id,@Body Person objPet);
}
