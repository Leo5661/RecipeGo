package com.example.recipego.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.recipego.Model.RecipesModel;
import com.example.recipego.Network.ApiClient;
import com.example.recipego.Network.RecipesApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesViewModel extends ViewModel {

    private MutableLiveData<List<RecipesModel>> recipesList;

    public RecipesViewModel(){
        recipesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<RecipesModel>> getRecipesList(){
        return recipesList;
    }
    public void getRecipesCall(String cuisine, String diet, String Api_Key){
        RecipesApiInterface apiService = ApiClient.getClient().create(RecipesApiInterface.class);
        Call<List<RecipesModel>> call = apiService.getRecipes(cuisine,diet,Api_Key);
        call.enqueue(new Callback<List<RecipesModel>>() {
            @Override
            public void onResponse(Call<List<RecipesModel>> call, Response<List<RecipesModel>> response) {
                recipesList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RecipesModel>> call, Throwable t) {
                Log.d("Log_Test", "onFailure: the api call is failed");
                recipesList.postValue(null);
            }
        });
    }

}
