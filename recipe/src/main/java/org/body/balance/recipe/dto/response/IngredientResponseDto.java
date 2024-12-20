package org.body.balance.recipe.dto.response;

import lombok.Builder;

@Builder // todo - Вопрос - Builder - это же доп память, зачем он нам тут?
public record IngredientResponseDto(String ingredientId,
                                    String ingredientName,
                                    Long unitId,
                                    String unitName,
                                    String unitShortName,
                                    Long amount) {
}
