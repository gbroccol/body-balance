package org.body.balance.recipe.domain.food;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RecipeIngredientId implements Serializable {

    @Column(name = "recipe_id")
    private UUID recipeId;

    @Column(name = "product_id")
    private UUID productId;

}