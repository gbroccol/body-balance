package org.body.balance.content.recipe.dto.request;

public record IngredientRequestDto(String ingredientId,
                                   Long unitId,
                                   Long amount) {
}
