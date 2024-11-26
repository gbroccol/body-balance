package org.body.balance.content.recipe.dto.response;

import lombok.Builder;

@Builder
public record StepResponseDto(Integer stepNumber,
                              String description) {
}
