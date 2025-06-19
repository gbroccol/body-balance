package org.body.balance.recipe.dto.request;

import java.util.UUID;

public record RecipeIngredientRequestDto(UUID id,
                                         Long unitId,
                                         Long quantity) {
}
