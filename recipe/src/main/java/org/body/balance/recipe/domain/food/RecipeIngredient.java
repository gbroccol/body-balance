package org.body.balance.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.body.balance.recipe.domain.dictionary.UnitOfMeasurement;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "food")
public class RecipeIngredient {

    @EmbeddedId
    private RecipeIngredientId id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product; // todo заполнить при сохранении

    @ManyToOne
    @JoinColumn(name = "unit_of_measurement_id")
    private UnitOfMeasurement unitOfMeasurement; // todo заполнить при сохранении

    private Long quantity;
}