package com.example.appjob.retrofitRemote;

import com.example.appjob.iRetrofit.PersonService;
import com.example.appjob.model.Person;

public class APIUtils {

    public static final String API_URL = "http://192.168.100.1:8080/person";

        private APIUtils() {
        }


        public static PersonService getUserService(){
        return RetrofitClient.getClient(API_URL).create(PersonService.class);
    }
}
