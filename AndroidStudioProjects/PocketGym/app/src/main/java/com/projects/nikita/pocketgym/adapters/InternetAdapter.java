package com.projects.nikita.pocketgym.adapters;

import com.projects.nikita.pocketgym.API.CategoriesAPI;
import com.projects.nikita.pocketgym.model.CategoriesModel;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by Nikita on 10/8/2015.
 */
public class InternetAdapter {
    static final String API = "http://nkt100194.at.ua";
    protected RestAdapter restAdapter;
    protected CategoriesAPI catapi;

    public InternetAdapter(){
        restAdapter = new RestAdapter.Builder().setEndpoint(API).build();
        catapi = restAdapter.create(CategoriesAPI.class);
    }

    public void getFeed(String file, Callback<CategoriesModel> response){
        catapi.getFeed(file, response);
     }

}
