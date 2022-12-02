package com.abn.recipe;

import com.abn.recipe.controller.RecipeController;
import com.abn.recipe.dao.RecipeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RecipeAppApplicationTests {

  @Autowired
  private RecipeRepository recipeRepository;

  @Autowired
  private RecipeController recipeController;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void contextLoads() {
    Assertions.assertThat(recipeRepository).isNotNull();
    Assertions.assertThat(recipeController).isNotNull();
    Assertions.assertThat(mockMvc).isNotNull();
  }
}
