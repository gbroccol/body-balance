package org.body.balance.content.recipe.domain.food;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;

@Getter // todo нужен???
@Setter // todo нужен???
@Embeddable
@NoArgsConstructor // todo нужен???
@AllArgsConstructor
@EqualsAndHashCode
public class RecipeIngredientId implements Serializable {

    @Column(name = "recipe_id")
    private String recipeId;

    @Column(name = "ingredient_id")
    private String ingredientId;

}