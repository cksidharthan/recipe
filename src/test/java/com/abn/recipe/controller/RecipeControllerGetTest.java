package com.abn.recipe.controller;

import com.abn.recipe.utils.Utils;
import org.json.JSONObject;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
  @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/insert.sql"),
  @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/delete.sql")
})
public class RecipeControllerGetTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getAllRecipes() throws Exception {
    JSONObject expectedResponse = Utils.readJSONFile("src/test/resources/json/initial-recipes.json");
    this.mockMvc.perform(get("/recipe")
            .contentType("application/json"))
            .andExpect(jsonPath("data").isArray())
            .andExpect(jsonPath("data").isNotEmpty())
            .andExpect(jsonPath("data").value(expectedResponse.getJSONArray("data").toList()))
            .andExpect(jsonPath("data.length()").value(4))
            .andExpect(status().isOk());
  }

    @Test
    void getRecipeById() throws Exception {
      JSONObject expectedResponse = Utils.readJSONFile("src/test/resources/json/recipe-id-1.json");
      this.mockMvc.perform(get("/recipe/1")
            .contentType("application/json"))
            .andExpect(jsonPath("data").isMap())
            .andExpect(jsonPath("data").isNotEmpty())
            .andExpect(jsonPath("data").value(expectedResponse.getJSONObject("data").toMap()))
            .andExpect(status().isOk());
    }

    @Test
    void getRecipeByIdNotFound() throws Exception {
      this.mockMvc.perform(get("/recipe/100")
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void getRecipeByInvalidId() throws Exception {
      this.mockMvc.perform(get("/recipe/invalid")
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getRecipeByInvalidPath() throws Exception {
      this.mockMvc.perform(get("/recipe/invalid/invalid")
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }
}

