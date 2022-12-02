package com.abn.recipe.dao;

import com.abn.recipe.entity.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * This interface is used to handle all the database operations related to Recipe.
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
