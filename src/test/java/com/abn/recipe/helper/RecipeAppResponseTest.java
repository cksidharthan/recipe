package com.abn.recipe.helper;

import com.abn.recipe.entity.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecipeAppResponseTest {
  @Test
  void createRecipeAppResponse() {
    RecipeAppResponse response = new RecipeAppResponse<>();

    Assertions.assertNotNull(response);
    Assertions.assertNull(response.getData());
    Assertions.assertNull(response.getMessage());
  }

  @Test
  void createRecipeAppResponseWithMessage() {
    RecipeAppResponse response = new RecipeAppResponse<>(new Recipe(), "created");

    Assertions.assertNotNull(response);
    Assertions.assertEquals("created", response.getMessage());
  }
}
