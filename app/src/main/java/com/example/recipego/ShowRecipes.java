package com.example.recipego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.recipego.Adapter.RecipeListAdapter;
import com.example.recipego.Model.RecipesModel;
import com.example.recipego.ViewModel.RecipesViewModel;

import java.util.List;

public class ShowRecipes extends AppCompatActivity {

    private String cuisine, diet;
    private List<RecipesModel> recipesModelList;
    private RecipeListAdapter adapter;
    private RecipesViewModel recipesViewModel;
    private String API_KEY = "08241d5ecd9d4bc1aa375a0b3b50af89";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipes);

        cuisine = getIntent().getStringExtra("cuisine");
        diet = getIntent().getStringExtra("diet");

        RecyclerView recyclerView = findViewById(R.id.recipes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecipeListAdapter(this, recipesModelList);
        recyclerView.setAdapter(adapter);

        recipesViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication())).get(RecipesViewModel.class);

        recipesViewModel.getRecipesList().observe(this, new Observer<List<RecipesModel>>() {
            @Override
            public void onChanged(List<RecipesModel> recipesModels) {
                if (recipesModels != null) {
                    recipesModelList = recipesModels;
                    adapter.setRecipeList(recipesModels);
                }
            }
        });
        recipesViewModel.getRecipesCall(cuisine, diet, API_KEY);
    }
}