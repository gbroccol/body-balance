package org.body.balance.user.controller;

import lombok.RequiredArgsConstructor;
import org.body.balance.user.dto.UserDtoResponse;
import org.body.balance.user.service.GetUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControllerV1 implements UserControllerV1OpenAPI {

    private final GetUserService getUserService;

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers(@RequestParam(name = "page", required = false) Integer page,
                                                             @RequestParam(name = "size", required = false) Integer size) {
        // todo прокидывать params в БД - добавила, чтобы был пример для swagger, исправлю позже
        return new ResponseEntity<>(getUserService.handleRequest(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDtoResponse> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(getUserService.handleRequest(username), HttpStatus.OK);
    }
}
