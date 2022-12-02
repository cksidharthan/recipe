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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/insert.sql"),
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/delete.sql")
})
public class RecipeControllerPutTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void updateRecipe() throws Exception {
    this.mockMvc.perform(put("/recipe/1")
        .contentType("application/json")
        .content("{\n" +
            "  \"id\": \"1\",\n" +
            "  \"description\": \"Sample Description\",\n" +
            "  \"directions\": \"Sample Directions\",\n" +
            "  \"ingredients\": \"Sample Ingredients\",\n" +
            "  \"name\": \"Sample Name\",\n" +
            "  \"prepTime\": 2,\n" +
            "  \"servings\": 34\n" +
            "}"))
        .andExpect(status().isOk());

    this.mockMvc.perform(get("/recipe/1")
        .contentType("application/json"))
        .andExpect(jsonPath("data").isNotEmpty())
        .andExpect(jsonPath("data.name").value("Sample Name"))
        .andExpect(jsonPath("data.description").value("Sample Description"))
        .andExpect(jsonPath("data.directions").value("Sample Directions"))
        .andExpect(jsonPath("data.ingredients").value("Sample Ingredients"))
        .andExpect(jsonPath("data.prepTime").value(2))
        .andExpect(jsonPath("data.servings").value(34));
  }

  @Test
  void updateRecipe_InvalidId() throws Exception {
    this.mockMvc.perform(put("/recipe/100")
        .contentType("application/json")
        .content("{\n" +
            "  \"id\": \"100\",\n" +
            "  \"description\": \"Sample Description\",\n" +
            "  \"directions\": \"Sample Directions\",\n" +
            "  \"ingredients\": \"Sample Ingredients\",\n" +
            "  \"name\": \"Sample Name\",\n" +
            "  \"prepTime\": 2,\n" +
            "  \"servings\": 34\n" +
            "}"))
        .andExpect(status().isNotFound());
  }
}
