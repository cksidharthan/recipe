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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class RecipeControllerPostTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
    void createRecipe() throws Exception {
        this.mockMvc.perform(post("/recipe")
                .contentType("application/json")
                .content("{\n" +
                    "  \"description\": \"Sample Description\",\n" +
                    "  \"directions\": \"Sample Directions\",\n" +
                    "  \"ingredients\": \"Sample Ingredients\",\n" +
                    "  \"name\": \"Sample Name\",\n" +
                    "  \"prepTime\": 2,\n" +
                    "  \"servings\": 34\n" +
                    "}"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(get("/recipe")
                .contentType("application/json"))
                .andExpect(jsonPath("data").isArray())
                .andExpect(jsonPath("data").isNotEmpty())
                .andExpect(jsonPath("data.length()").value(5));
    }

    @Test
    void createRecipeWithNoBody() throws Exception {
        this.mockMvc.perform(post("/recipe")
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createRecipeWithNoName() throws Exception {
        this.mockMvc.perform(post("/recipe")
                .contentType("application/json")
                .content("{\n" +
                    "  \"description\": \"Sample Description\",\n" +
                    "  \"directions\": \"Sample Directions\",\n" +
                    "  \"ingredients\": \"Sample Ingredients\",\n" +
                    "  \"prepTime\": 2,\n" +
                    "  \"servings\": 34\n" +
                    "}"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void createRecipeWithNoDescription() throws Exception {
        this.mockMvc.perform(post("/recipe")
                .contentType("application/json")
                .content("{\n" +
                    "  \"directions\": \"Sample Directions\",\n" +
                    "  \"ingredients\": \"Sample Ingredients\",\n" +
                    "  \"name\": \"Sample Name\",\n" +
                    "  \"prepTime\": 2,\n" +
                    "  \"servings\": 34\n" +
                    "}"))
                .andExpect(status().isInternalServerError());
    }
}
