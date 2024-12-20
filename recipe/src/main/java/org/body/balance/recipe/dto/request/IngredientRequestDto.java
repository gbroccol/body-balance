package org.body.balance.recipe.dto.request;

public record IngredientRequestDto(String ingredientId,
                                   Long unitId,
                                   Long amount) {
}
