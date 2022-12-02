package com.abn.recipe.entity;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Recipe entity class that maps to the recipe table in the database.
 */
@Entity
@Table(name = "RECIPE")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false, nullable = false)
  private Long id;

  @Column(name = "NAME")
  @NotNull
  private String name;

  @Column(name = "IS_VEGETARIAN")
  @NotNull
  private Boolean isVegetarian;

  @Column(name = "DESCRIPTION")
  @NotNull
  private String description;

  @Column(name = "INGREDIENTS")
  @NotNull
  private String ingredients;

  @Column(name = "DIRECTIONS")
  @NotNull
  private String directions;

  @Column(name = "SERVINGS")
  @NotNull
  private int servings;

  @Column(name = "PREP_TIME")
  @NotNull
  private int prepTime;

}
