package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder
public record StepResponseDto(Integer stepNumber,
                              String description) {
}
