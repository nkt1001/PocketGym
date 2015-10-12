package com.projects.nikita.pocketgym.API;

import com.projects.nikita.pocketgym.model.CategoriesModel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;


/**
 * Created by Nikita on 10/8/2015.
 */
public interface CategoriesAPI {
    @GET("/{file}") //here is the other url part.best way is to start using /
    void getFeed(@Path("file") String file, Callback<CategoriesModel> response);

}
