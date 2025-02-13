package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder
public record TagResponseDto(Long tagId,
                             String name) {
}
