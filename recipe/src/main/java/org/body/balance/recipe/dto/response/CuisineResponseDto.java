package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder
public record CuisineResponseDto(Long cuisineId,
                                 String name) {
}
