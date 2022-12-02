package com.abn.recipe.dao.impl;

import com.abn.recipe.dao.RecipeRepositoryCustom;
import com.abn.recipe.entity.Recipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepositoryCustomImpl implements RecipeRepositoryCustom {

  @PersistenceContext
  EntityManager entityManager;
  public List<Recipe> findRecipesByFilters(boolean isVegetarian, String excludeIngredients,
      String includeIngredients, Integer servings, String instructions) throws Exception {
    String isVegetarianQuery = "";
    if (isVegetarian) {
      isVegetarianQuery = "AND r.isVegetarian = true";
    }

    String excludeIngredientsQuery = "";
    if (excludeIngredients != null) {
      excludeIngredientsQuery = "AND r.ingredients NOT LIKE '%"+excludeIngredients+"%'";
    }

    String includeIngredientsQuery = "";
    if (includeIngredients != null) {
      includeIngredientsQuery = "AND r.ingredients LIKE '%"+includeIngredients+"%'";
    }

    String servingsQuery = "";
    if (servings != null) {
      servingsQuery = "AND r.servings = "+servings;
    }

    String instructionsQuery = "";
    if (instructions != null) {
      instructionsQuery = "AND r.instructions LIKE '%"+instructions+"%'";
    }

    String query = "SELECT r FROM Recipe r WHERE 1=1 "
        + isVegetarianQuery
        + excludeIngredientsQuery
        + includeIngredientsQuery
        + servingsQuery
        + instructionsQuery;

    return entityManager.createQuery(query, Recipe.class).getResultList();
  }
}
