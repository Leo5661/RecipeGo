package com.example.recipego.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recipego.Model.RecipesModel;
import com.example.recipego.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private Context context;
    private List<RecipesModel> recipeList;

    public RecipeListAdapter(Context context, List<RecipesModel> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    public void setRecipeList(List<RecipesModel> recipeList) {
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipes_item_list_view, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.mTitle.setText(this.recipeList.get(position).getTitle());
        Glide.with(context)
                .load(this.recipeList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        if (this.recipeList != null) {
            return this.recipeList.size();
        }
        return 0;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        MaterialTextView mTitle;
        ShapeableImageView mImage;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.recipe_name);
            mImage = itemView.findViewById(R.id.recipe_image);
        }
    }

}
