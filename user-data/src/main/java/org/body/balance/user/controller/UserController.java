package org.body.balance.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.body.balance.user.dto.UserDto;
import org.body.balance.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/api/v1/user")
    public ResponseEntity<List<UserDto>> getAll(HttpServletRequest request) {

        log.info("[POST /api/v1/user] g_id = {}", request.getHeader("g_id")); // todo ЧЕТ НЕ ОЧЕНЬ

        return new ResponseEntity<>(
                userService.findAll().stream()
                        .map(UserDto::toDto)
                        .toList(),
                HttpStatus.OK);
    }
}
