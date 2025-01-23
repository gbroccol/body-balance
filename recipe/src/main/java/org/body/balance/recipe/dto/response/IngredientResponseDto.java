package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder
public record IngredientResponseDto(String ingredientId,
                                    String ingredientName,
                                    Long unitId,
                                    String unitName,
                                    String unitShortName,
                                    Long amount) {
}
