package com.abn.recipe.helper;

import lombok.*;
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
