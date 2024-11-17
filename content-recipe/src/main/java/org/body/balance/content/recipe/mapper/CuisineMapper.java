package org.body.balance.content.recipe.mapper;

import org.body.balance.content.recipe.domain.dictionary.Cuisine;
import org.body.balance.content.recipe.dto.CuisineResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuisineMapper {

    CuisineResponseDto toResponseDto(Cuisine cuisine);

}