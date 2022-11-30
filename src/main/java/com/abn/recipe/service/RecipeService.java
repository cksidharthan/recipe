package com.abn.recipe.service;

import com.abn.recipe.entity.Recipe;
import java.util.List;

public interface RecipeService {
    Recipe getRecipeById(Integer id) throws Exception;

    Recipe saveRecipe(Recipe recipe) throws Exception;

    Recipe updateRecipe(Recipe recipe) throws Exception;

    void deleteRecipeById(Integer id) throws Exception;

    void deleteAllRecipes() throws Exception;

    List<Recipe> getAllRecipes() throws Exception;

}
