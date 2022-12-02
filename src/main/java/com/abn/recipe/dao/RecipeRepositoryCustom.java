package com.abn.recipe.dao;

import com.abn.recipe.entity.Recipe;
import java.util.List;

public interface RecipeRepositoryCustom {
  List<Recipe> findRecipesByFilters(
      boolean isVegetarian,
      String excludeIngredients,
      String includeIngredients,
      Integer servings,
      String instructions
  ) throws Exception;
}
