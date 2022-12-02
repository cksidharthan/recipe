package com.abn.recipe.service.impl;

import com.abn.recipe.controller.RecipeController;
import com.abn.recipe.dao.RecipeRepository;
import com.abn.recipe.dao.RecipeRepositoryCustom;
import com.abn.recipe.entity.Recipe;
import com.abn.recipe.service.RecipeService;
import java.util.List;
import javassist.NotFoundException;
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

  private final RecipeRepositoryCustom recipeRepositoryCustom;

  public RecipeServiceImpl(RecipeRepository recipeRepository,
      RecipeRepositoryCustom recipeRepositoryCustom) {
    this.recipeRepository = recipeRepository;
    this.recipeRepositoryCustom = recipeRepositoryCustom;
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
      if (recipeRepository.existsById(Long.valueOf(id))) {
        recipeRepository.deleteById(Long.valueOf(id));
        logger.info("Successfully deleted recipe with id: " + id);
      } else {
        logger.error("Recipe with id: " + id + " does not exist");
        throw new NotFoundException("Recipe with id: " + id + " does not exist");
      }
    } catch (Exception e) {
      logger.error("Error deleting recipe with id: " + id);
      if (e instanceof NotFoundException) {
        throw e;
      } else {
        throw new Exception("Error deleting recipe with id: " + id);
      }
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
      if (recipeRepository.existsById(recipe.getId())) {
        return recipeRepository.save(recipe);
      } else {
        logger.error("Recipe with id: " + recipe.getId() + " does not exist");
        throw new NotFoundException("Recipe with id: " + recipe.getId() + " does not exist");
      }
    } catch (Exception e) {
      logger.error("Error updating recipe with id: " + recipe.getId());
      if (e instanceof NotFoundException) {
        throw e;
      } else {
        throw new Exception("Error updating recipe with id: " + recipe.getId());
      }
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
  public Recipe getRecipeById(Integer id) throws Exception {
    logger.debug("Getting all recipe from database");
    try {
      if (recipeRepository.existsById(Long.valueOf(id))) {
        return recipeRepository.findById(Long.valueOf(id)).get();
      } else {
        throw new NotFoundException("Recipe with id: " + id + " does not exist");
      }
    } catch (Exception e) {
      logger.error("Error getting recipe with id: " + id);
      if (e instanceof NotFoundException) {
        throw e;
      } else {
        throw new Exception("Error getting recipe with id: " + id);
      }
    }
  }

  /**
   * This method is used to get all recipes from the database.
   *
   * @return list of recipes
   */
  public List<Recipe> getAllRecipes(
      boolean isVegetarian,
      String excludeIngredients,
      String includeIngredients,
      Integer servings,
      String instructions
  ) throws Exception {
    logger.debug("Getting all recipes from database");
    try {
      return recipeRepositoryCustom.findRecipesByFilters(
        isVegetarian,
        excludeIngredients,
        includeIngredients,
        servings,
        instructions
      );
    } catch (Exception e) {
      logger.error("Error getting all recipes from database");
      throw new Exception("Error getting all recipes from database");
    }
  }
}
