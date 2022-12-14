package com.abn.recipe.dao.impl;

import com.abn.recipe.dao.RecipeRepositoryCustom;
import com.abn.recipe.entity.Recipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/** This class is used to define custom methods for RecipeRepositoryCustom. */
@Repository
public class RecipeRepositoryCustomImpl implements RecipeRepositoryCustom {

  @PersistenceContext
  EntityManager entityManager;

  /**
   * findRecipesByFilters is used to find recipes by filters.
   *
   * @return list of recipes
   */
  public List<Recipe> findRecipesByFilters(boolean isVegetarian, String excludeIngredients,
      String includeIngredients, Integer servings, String instructions) throws Exception {

    List<Recipe> recipes;

    String isVegetarianQuery = "";
    if (isVegetarian) {
      isVegetarianQuery = "AND r.isVegetarian = true ";
    }

    String excludeIngredientsQuery = "";
    if (excludeIngredients != null) {
      excludeIngredientsQuery = "AND r.ingredients NOT LIKE '%" + excludeIngredients + "%'";
    }

    String includeInstructionsQuery = "";
    if (includeIngredients != null) {
      includeInstructionsQuery = "AND r.instructions LIKE '%" + includeIngredients + "%'";
    }

    String servingsQuery = "";
    if (servings != null) {
      servingsQuery = "AND r.servings = " + servings;
    }

    String instructionsQuery = "";
    if (instructions != null) {
      instructionsQuery = "AND r.instructions LIKE '%" + instructions + "%'";
    }

    String query = "SELECT r FROM Recipe r WHERE 1=1 "
        + isVegetarianQuery
        + excludeIngredientsQuery
        + includeInstructionsQuery
        + servingsQuery
        + instructionsQuery;

    try {
      recipes = entityManager.createQuery(query, Recipe.class).getResultList();
    } catch (Exception e) {
      throw new Exception("Internal server error");
    }
    return recipes;
  }
}
