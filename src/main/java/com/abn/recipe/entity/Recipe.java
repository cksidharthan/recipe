package com.abn.recipe.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="RECIPE")
@Getter @Setter @ToString @NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

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

    public Recipe(String name, String description, String ingredients, String directions, int servings, int prepTime) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        this.servings = servings;
        this.prepTime = prepTime;
    }
}