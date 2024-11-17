
package org.body.balance.content.recipe.mapper;

import org.body.balance.content.recipe.domain.dictionary.Tag;
import org.body.balance.content.recipe.dto.TagResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagResponseDto toResponseDto(Tag tag);

}