package com.abn.recipe.service.impl;

import com.abn.recipe.controller.RecipeController;
import com.abn.recipe.dao.RecipeRepository;
import com.abn.recipe.entity.Recipe;
import com.abn.recipe.service.RecipeService;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
  * This class is used to handle all the business logic related to Recipe.
 */
@Service
public class RecipeServiceImpl implements RecipeService {
  private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);
  private final RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  /**
   * This method is used to get a recipe by id from the database.
   *
   * @param id
   *
   */
  @Transactional
  public void deleteRecipeById(Integer id) throws Exception {
    logger.info("Deleting recipe with id: " + id);
    try {
      recipeRepository.deleteById(id);
    } catch (Exception e) {
      logger.error("Error deleting recipe with id: " + id);
      throw new Exception("Error deleting recipe with id: " + id);
    }
  }

  /**
   * This method is used to get a recipe by id from the database.
   *
   */
  @Transactional
  public void deleteAllRecipes() throws Exception {
    logger.debug("Deleting all recipes from database");
    try {
      recipeRepository.deleteAll();
    } catch (Exception e) {
      logger.error("Error deleting all recipes from database");
      throw new Exception("Error deleting all recipes from database");
    }
  }

  /**
   * This method is used to get a recipe by id from the database.
   *
   * @param recipe
   *
   * @return Recipe
   *
   */
  @Transactional
  public Recipe updateRecipe(Recipe recipe) throws Exception {
    logger.debug("Updating recipe with id: " + recipe.getId());
    try {
      return recipeRepository.save(recipe);
    } catch (Exception e) {
      logger.error("Error updating recipe with id: " + recipe.getId());
      throw new Exception("Error updating recipe with id: " + recipe.getId());
    }
  }

  /**
   * This method is used to get a recipe by id from the database.
   *
   * @param recipe
   *
   * @return Recipe
   */
  @Transactional
  public Recipe saveRecipe(Recipe recipe) throws Exception {
    logger.debug("Saving recipe to database");
    try {
      return recipeRepository.save(recipe);
    } catch (Exception e) {
      logger.error("Error saving recipe to database");
      throw new Exception("Error saving recipe to database");
    }
  }

  /**
   * This method is used to get a recipe by id from the database.
   *
   * @param id
   *
   * @return Recipe
   */
  @Transactional
  public Recipe getRecipeById(Integer id) throws Exception {
    logger.debug("Getting all recipe from database");
    try {
      return recipeRepository.findById(id).get();
    } catch (Exception e) {
      logger.error("Error getting recipe with id: " + id);
      throw new Exception("Error getting recipe with id: " + id);
    }
  }

  /**
   * This method is used to get all recipes from the database.
   *
   * @return list of recipes
   */
  @Transactional
  public List<Recipe> getAllRecipes() throws Exception {
    logger.debug("Getting all recipes from database");
    try {
      return recipeRepository.findAll();
    } catch (Exception e) {
      logger.error("Error getting all recipes from database");
      throw new Exception("Error getting all recipes from database");
    }
  }
}
