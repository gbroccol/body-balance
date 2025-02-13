package org.body.balance.user.service;

import org.body.balance.user.dto.UserDtoResponse;
import org.body.balance.user.exception.ErrorMessages;
import org.body.balance.user.exception.UserNotFoundException;
import org.body.balance.user.mapper.UserMapper;
import org.body.balance.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.body.balance.user.domain.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public record GetUserService(UserRepository repository,
                             UserMapper userMapper) {

    public List<UserDtoResponse> handleRequest() {
        Iterable<User> users = repository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::toDtoResponse)
                .collect(Collectors.toList());
    }

    public UserDtoResponse handleRequest(String username) {
        return userMapper.toDtoResponse(
                repository.findByUsername(username)
                        .orElseThrow(() -> new UserNotFoundException((ErrorMessages.USERNAME_NOT_FOUND.getValue()).formatted(username))));
    }
}
