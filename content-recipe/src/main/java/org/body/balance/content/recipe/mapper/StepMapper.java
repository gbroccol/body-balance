package org.body.balance.content.recipe.mapper;

import org.body.balance.content.recipe.domain.food.Step;
import org.body.balance.content.recipe.dto.StepResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StepMapper {

    StepResponseDto toResponseDto(Step step);

}