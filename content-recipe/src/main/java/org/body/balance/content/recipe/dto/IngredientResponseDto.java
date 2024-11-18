package org.body.balance.content.recipe.dto;

public record IngredientResponseDto(String ingredientId,
                                    String ingredientName,
                                    Long unitId,
                                    String unitName,
                                    String unitShortName,
                                    Long amount) {
}
