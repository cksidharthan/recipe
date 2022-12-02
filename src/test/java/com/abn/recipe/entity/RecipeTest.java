package com.abn.recipe.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecipeTest {
  @Test
  public void testRecipe() {
      Recipe recipe = new Recipe();
      recipe.setId(1L);
      recipe.setName("name");
      recipe.setDescription("description");
      recipe.setIngredients("ingredients");
      recipe.setDirections("directions");
      recipe.setServings(1);
      recipe.setPrepTime(1);

      Recipe expectedRecipe = new Recipe(
          1L,
          "name",
          false,
          "description",
          "ingredients",
          "directions",
          1,
          1
      );

      Assertions.assertEquals(expectedRecipe.getId(), recipe.getId());
      Assertions.assertEquals(expectedRecipe.getName(), recipe.getName());
      Assertions.assertEquals(expectedRecipe.getDescription(), recipe.getDescription());
      Assertions.assertEquals(expectedRecipe.getIngredients(), recipe.getIngredients());
      Assertions.assertEquals(expectedRecipe.getDirections(), recipe.getDirections());
      Assertions.assertEquals(expectedRecipe.getServings(), recipe.getServings());
      Assertions.assertEquals(expectedRecipe.getPrepTime(), recipe.getPrepTime());
  }

  @Test
  public void testRecipeToString() {
      Recipe recipe = new Recipe();
      recipe.setId(1L);
      recipe.setName("name");
      recipe.setIsVegetarian(true);
      recipe.setDescription("description");
      recipe.setIngredients("ingredients");
      recipe.setDirections("directions");
      recipe.setServings(1);
      recipe.setPrepTime(1);

      String expectedRecipe = "Recipe(id=1, name=name, isVegetarian=true, description=description, ingredients=ingredients, directions=directions, servings=1, prepTime=1)";

      Assertions.assertEquals(expectedRecipe, recipe.toString());
  }

  @Test
  public void testRecipeEquals() {
      Recipe recipe = new Recipe(
          1L,
          "name",
          false,
          "description",
          "ingredients",
          "directions",
          1,
          1
      );

      Assertions.assertEquals(recipe.getName(), "name");
      Assertions.assertEquals(recipe.getDescription(), "description");
      Assertions.assertEquals(recipe.getIngredients(), "ingredients");
      Assertions.assertEquals(recipe.getDirections(), "directions");
      Assertions.assertEquals(recipe.getServings(), 1);
      Assertions.assertEquals(recipe.getPrepTime(), 1);
  }

}
