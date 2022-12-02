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

  @Test
    void deleteRecipe() throws Exception {
        this.mockMvc.perform(delete("/recipe/1")
            .contentType("application/json"))
            .andExpect(status().isOk());
    }

    @Test
    void deleteRecipe_InvalidId() throws Exception {
        this.mockMvc.perform(delete("/recipe/100")
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void deleteRecipe_InvalidIdFormat() throws Exception {
        this.mockMvc.perform(delete("/recipe/abc")
            .contentType("application/json"))
            .andExpect(status().isInternalServerError());
    }

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
