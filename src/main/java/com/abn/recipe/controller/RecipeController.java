package com.abn.recipe.controller;

import com.abn.recipe.entity.Recipe;
import com.abn.recipe.helper.RecipeAppResponse;
import com.abn.recipe.service.RecipeService;
import java.util.List;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
  * This class is used to handle all the requests related to Recipe.
 */
@RestController
@CrossOrigin
public class RecipeController {

  private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);
  private final RecipeService recipeService;

  @Autowired
  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  /**
   * This method is used to get all the recipes from the database.
   *
   * @return RecipeAppResponse
   */
  @GetMapping("/recipe")
  public ResponseEntity<RecipeAppResponse<List<Recipe>>> getAllRecipes(
      @RequestParam(required = false) boolean isVegetarian,
      @RequestParam(required = false) String excludeIngredients,
      @RequestParam(required = false) String includeInstructions,
      @RequestParam(required = false) Integer servings,
      @RequestParam(required = false) String instructions
  ) {
    logger.info("Getting all recipes");
    try {
      List<Recipe> recipes = recipeService.getAllRecipes(
            isVegetarian,
            excludeIngredients,
            includeInstructions,
            servings,
            instructions
        );
      logger.info("Successfully retrieved all recipes");
      return new ResponseEntity<>(new RecipeAppResponse<>(recipes,
          "Successfully retrieved all recipes"), HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Error getting all recipes", e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Error getting all recipes"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * This method is used to get a recipe by id from the database.
   *
   * @param id
   *
   * @return RecipeAppResponse
   */
  @GetMapping("/recipe/{id}")
  public ResponseEntity<RecipeAppResponse<Recipe>> getRecipeById(@PathVariable Integer id) {
    logger.info("Getting recipe with id: " + id);
    try {
      Recipe recipe = recipeService.getRecipeById(id);
      logger.info("Successfully retrieved recipe with id: " + id);
      return new ResponseEntity<>(new RecipeAppResponse<>(recipe,
          "Successfully retrieved recipe with id: " + id), HttpStatus.OK);
    } catch (NotFoundException e) {
      logger.error("Recipe with id: " + id + " not found", e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Recipe with id: " + id + " not found"), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      logger.error("Error getting recipe with id: " + id, e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Error getting recipe with id: " + id), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * This method is used to save a recipe to the database.
   *
   * @param recipe
   *
   * @return RecipeAppResponse
   */
  @PostMapping("/recipe")
  public ResponseEntity<RecipeAppResponse<Recipe>> saveRecipe(@RequestBody Recipe recipe) {
    logger.info("Saving recipe");
    logger.info("Recipe: " + recipe);
    try {
      Recipe savedRecipe = recipeService.saveRecipe(recipe);
      logger.info("Successfully saved recipe");
      return new ResponseEntity<>(new RecipeAppResponse<>(savedRecipe,
          "Successfully saved recipe"), HttpStatus.CREATED);
    } catch (Exception e) {
      logger.error("Error saving recipe", e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Error saving recipe"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * This method is used to update a recipe in the database.
   *
   * @param recipe
   *
   * @return RecipeAppResponse
   */
  @PutMapping("/recipe/{id}")
  public ResponseEntity<RecipeAppResponse<Recipe>> updateRecipe(@RequestBody Recipe recipe) {
    logger.info("Updating recipe");
    logger.debug("Recipe: " + recipe);
    try {
      Recipe updatedRecipe = recipeService.updateRecipe(recipe);
      logger.info("Successfully updated recipe");
      return new ResponseEntity<>(new RecipeAppResponse<>(updatedRecipe,
          "Successfully updated recipe"), HttpStatus.OK);
    } catch (NotFoundException e) {
      logger.error("Recipe with id: " + recipe.getId() + " not found", e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Recipe with id: " + recipe.getId() + " not found"), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      logger.error("Error updating recipe", e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Error updating recipe"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * This method is used to delete a recipe from the database.
   *
   * @param id
   *
   * @return RecipeAppResponse
   */
  @DeleteMapping("/recipe/{id}")
  public ResponseEntity<RecipeAppResponse<Recipe>> deleteRecipeById(@PathVariable String id) {
    logger.info("Deleting recipe with id: " + id);
    logger.debug("Recipe id: " + id);
    try {
      recipeService.deleteRecipeById(Integer.parseInt(id));
      logger.info("Successfully deleted recipe with id: " + id);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Successfully deleted recipe with id: " + id), HttpStatus.OK);
    } catch (NotFoundException e) {
      logger.error("Recipe with id: " + id + " not found", e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Recipe with id: " + id + " not found"), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      logger.error("Error deleting recipe with id: " + id, e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Error deleting recipe with id: " + id), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * This method is used to delete all recipes from the database.
   *
   * @return RecipeAppResponse
   */
  @DeleteMapping("/recipe")
  public ResponseEntity<RecipeAppResponse<Recipe>> deleteAllRecipes() {
    logger.info("Deleting all recipes");
    try {
      recipeService.deleteAllRecipes();
      logger.info("Successfully deleted all recipes");
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Successfully deleted all recipes"), HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Error deleting all recipes", e);
      return new ResponseEntity<>(new RecipeAppResponse<>(null,
          "Error deleting all recipes"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
