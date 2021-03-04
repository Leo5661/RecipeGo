package com.example.recipego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout mCuisineText, mDietText;
    AutoCompleteTextView cuisineMenu, dietMenu;
    MaterialButton mFindRecipeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCuisineText = findViewById(R.id.cuisine_text);
        mDietText = findViewById(R.id.diet_text);
        cuisineMenu = findViewById(R.id.cuisine_menu);
        dietMenu = findViewById(R.id.diet_menu);
        mFindRecipeBtn = findViewById(R.id.find_recipe_button);

        getCuisineList();
        getDietList();

        mFindRecipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRecipe();
            }
        });

    }

    private void getCuisineList(){
        ArrayList<String> cuisineItems = new ArrayList<>();
        cuisineItems.add("African");
        cuisineItems.add("Indian");
        cuisineItems.add("American");
        cuisineItems.add("British");
        cuisineItems.add("Cajun");
        cuisineItems.add("Caribbean");
        cuisineItems.add("Eastern European");
        cuisineItems.add("Chinese");

        ArrayAdapter<String> cuisineAdapter = new ArrayAdapter(this, R.layout.list_item, cuisineItems);
        cuisineMenu.setAdapter(cuisineAdapter);
    }

    private void getDietList(){
        ArrayList<String> dietItems = new ArrayList<>();
        dietItems.add("Gluten Free");
        dietItems.add("Vegetarian");
        dietItems.add("Non-Veg");
        dietItems.add("Vegan");
        dietItems.add("Pescetarian");


        ArrayAdapter<String> cuisineAdapter = new ArrayAdapter(this, R.layout.list_item, dietItems);
        dietMenu.setAdapter(cuisineAdapter);
    }

    private void getRecipe(){

        String cuisine = mCuisineText.getEditText().getText().toString();
        String diet = mDietText.getEditText().getText().toString();

        Log.d("Log_test", "getRecipe: for cuisine: " + cuisine + " diet: " + diet);

    }
}