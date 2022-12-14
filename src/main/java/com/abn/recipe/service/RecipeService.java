package com.abn.recipe.service;

import com.abn.recipe.entity.Recipe;
import java.util.List;

/**
  * This interface is used to handle all the business logic related to Recipe.
 */
public interface RecipeService {
  Recipe getRecipeById(Integer id) throws Exception;

  Recipe saveRecipe(Recipe recipe) throws Exception;

  Recipe updateRecipe(Recipe recipe) throws Exception;

  void deleteRecipeById(Integer id) throws Exception;

  void deleteAllRecipes() throws Exception;

  List<Recipe> getAllRecipes(
        boolean isVegetarian,
        String excludeIngredients,
        String includeInstructions,
        Integer servings,
        String instructions
    ) throws Exception;

}
