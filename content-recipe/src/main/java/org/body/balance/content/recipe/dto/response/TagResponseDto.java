package org.body.balance.content.recipe.dto.response;

import lombok.Builder;

@Builder
public record TagResponseDto(Long tagId,
                             String name) {
}
