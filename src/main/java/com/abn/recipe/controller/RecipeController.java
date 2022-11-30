package com.abn.recipe.controller;

import com.abn.recipe.entity.Recipe;
import com.abn.recipe.helper.RecipeAppResponse;
import com.abn.recipe.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RecipeController {

    private final RecipeService recipeService;

    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public RecipeAppResponse<List<Recipe>> getAllRecipes() {
        logger.info("Getting all recipes");
        try {
            List<Recipe> recipes = recipeService.getAllRecipes();
            logger.info("Successfully retrieved all recipes");
            return new RecipeAppResponse<>(recipes, "Successfully retrieved all recipes", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting all recipes", e);
            return new RecipeAppResponse<>(null, "Error getting all recipes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recipe/{id}")
    public RecipeAppResponse<Recipe> getRecipeById(@PathVariable Integer id) {
        logger.info("Getting recipe with id: " + id);
        try {
            Recipe recipe = recipeService.getRecipeById(id);
            logger.info("Successfully retrieved recipe with id: " + id);
            return new RecipeAppResponse<>(recipe, "Successfully retrieved recipe with id: " + id, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting recipe with id: " + id, e);
            return new RecipeAppResponse<>(null, "Error getting recipe with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/recipe")
    public RecipeAppResponse<Recipe> saveRecipe(@RequestBody Recipe recipe) {
        logger.info("Saving recipe");
        logger.info("Recipe: " + recipe);
        try {
            Recipe savedRecipe = recipeService.saveRecipe(recipe);
            logger.info("Successfully saved recipe");
            return new RecipeAppResponse<>(savedRecipe, "Successfully saved recipe", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error saving recipe", e);
            return new RecipeAppResponse<>(null, "Error saving recipe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/recipe/{id}")
    public RecipeAppResponse<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        logger.info("Updating recipe");
        logger.debug("Recipe: " + recipe);
        try {
            Recipe updatedRecipe = recipeService.updateRecipe(recipe);
            logger.info("Successfully updated recipe");
            return new RecipeAppResponse<>(updatedRecipe, "Successfully updated recipe", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error updating recipe", e);
            return new RecipeAppResponse<>(null, "Error updating recipe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/recipe/{id}")
    public RecipeAppResponse<Recipe> deleteRecipeById(@PathVariable String id) {
        logger.info("Deleting recipe with id: " + id);
        logger.debug("Recipe id: " + id);
        try {
            recipeService.deleteRecipeById(Integer.parseInt(id));
            logger.info("Successfully deleted recipe with id: " + id);
            return new RecipeAppResponse<>(null, "Successfully deleted recipe with id: " + id, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error deleting recipe with id: " + id, e);
            return new RecipeAppResponse<>(null, "Error deleting recipe with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/recipe")
    public RecipeAppResponse<Recipe> deleteAllRecipes() {
        logger.info("Deleting all recipes");
        try {
            recipeService.deleteAllRecipes();
            logger.info("Successfully deleted all recipes");
            return new RecipeAppResponse<>(null, "Successfully deleted all recipes", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error deleting all recipes", e);
            return new RecipeAppResponse<>(null, "Error deleting all recipes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
