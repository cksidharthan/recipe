package com.abn.recipe.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecipeAppResponse<E> {
    private E data;
    private String message;
    private HttpStatus status;
}
