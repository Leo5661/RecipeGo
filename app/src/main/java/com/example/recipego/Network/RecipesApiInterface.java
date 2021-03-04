package com.example.recipego.Network;

import com.example.recipego.Model.RecipesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipesApiInterface {

    @GET("recipes/complexSearch")
    Call<List<RecipesModel>> getRecipes(@Query("cuisine") String cuisine, @Query("diet") String diet, @Query("apiKey") String Api_key);

}
