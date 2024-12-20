package org.body.balance.user.mapper;

import org.body.balance.user.domain.User;
import org.body.balance.user.dto.UserDtoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDtoResponse toDtoResponse(User user);
    User toEntity(UserDtoResponse userDtoResponse);
}