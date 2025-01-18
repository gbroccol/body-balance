package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder // todo - посмотреть через анализатор как влияет на память
public record IngredientResponseDto(String ingredientId,
                                    String ingredientName,
                                    Long unitId,
                                    String unitName,
                                    String unitShortName,
                                    Long amount) {
}
