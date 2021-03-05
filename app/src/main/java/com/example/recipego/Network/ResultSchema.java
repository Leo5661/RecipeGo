package com.example.recipego.Network;

import com.example.recipego.Model.RecipesModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultSchema {

    @SerializedName("results")
    @Expose
    private List<RecipesModel> results = null;

    public List<RecipesModel> getResults() {
        return results;
    }
}
