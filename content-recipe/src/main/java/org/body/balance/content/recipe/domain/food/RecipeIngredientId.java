package org.body.balance.content.recipe.domain.food;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RecipeIngredientId implements Serializable {

    private String recipeId;

    private String ingredientId;

}