package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder
public record RecipeStepResponseDto(Integer number,
                                    String text,
                                    String image) {
}
