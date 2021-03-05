package com.example.recipego.ViewModel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.recipego.Model.RecipesModel;
import com.example.recipego.Network.ApiClient;
import com.example.recipego.Network.RecipesApiInterface;
import com.example.recipego.Network.ResultSchema;

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

    public void getRecipesCall(String cuisine, String diet, String Api_Key) {
        RecipesApiInterface apiService = ApiClient.getClient().create(RecipesApiInterface.class);
        Call<ResultSchema> call = apiService.getRecipes(cuisine, diet, Api_Key);
        call.enqueue(new Callback<ResultSchema>() {
            @Override
            public void onResponse(Call<ResultSchema> call, Response<ResultSchema> response) {
                recipesList.postValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ResultSchema> call, Throwable t) {
                Log.d("Log_Test", "onFailure: the api call is failed" + " " + t.getMessage());
                recipesList.postValue(null);
                //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
