package com.abn.recipe.controller;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
  @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/insert.sql"),
  @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/delete.sql")
})
public class RecipeControllerDeleteTest {
  @Autowired
  private MockMvc mockMvc;

  /**
   * Test to check if the delete recipe with valid id endpoint is working.
   * @throws Exception
   */
  @Test
  void deleteRecipe() throws Exception {
    this.mockMvc.perform(delete("/recipe/1")
        .contentType("application/json"))
        .andExpect(status().isOk());
  }

  /**
   * Test to check if the delete recipe with invalid id endpoint is working as expected.
   * @throws Exception
   */
  @Test
  void deleteRecipe_InvalidId() throws Exception {
    this.mockMvc.perform(delete("/recipe/100")
        .contentType("application/json"))
        .andExpect(status().isNotFound());
  }

  /**
   * Test to check if the delete recipe with invalid id (alphanumeric) endpoint is working as expected.
   * @throws Exception
   */
  @Test
  void deleteRecipe_InvalidIdFormat() throws Exception {
    this.mockMvc.perform(delete("/recipe/abc")
        .contentType("application/json"))
        .andExpect(status().isInternalServerError());
  }

  /**
   * Test to check if delete all recipes endpoint is working as expected.
   * @throws Exception
   */
  @Test
  void deleteAllRecipes() throws Exception {
    this.mockMvc.perform(delete("/recipe")
        .contentType("application/json"))
        .andExpect(status().isOk());

    this.mockMvc.perform(get("/recipe")
        .contentType("application/json"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("data").isEmpty());
  }

}
