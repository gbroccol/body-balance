package org.body.balance.content.recipe.dto.response;

import lombok.Builder;

@Builder
public record CuisineResponseDto(Long cuisineId,
                                 String name) {
}
