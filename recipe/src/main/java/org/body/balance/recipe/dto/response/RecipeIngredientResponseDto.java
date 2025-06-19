package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder
public record RecipeIngredientResponseDto(String id,
                                          String name,
                                          String quantity) {
}
