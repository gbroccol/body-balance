package org.body.balance.user.controller;

import lombok.RequiredArgsConstructor;
import org.body.balance.user.dto.UserDtoResponse;
import org.body.balance.user.exception.UserNotFoundException;
import org.body.balance.user.service.GetUserService;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControllerV1 {

    private final GetUserService getUserService;

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        return new ResponseEntity<>(getUserService.handleRequest(), HttpStatus.OK);
    }

    @GetMapping(params = {"username"})
    public ResponseEntity<UserDtoResponse> getUserByUsername(@RequestParam String username) {
        return new ResponseEntity<>(getUserService.handleRequest(username), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorMessage getUserHandler(UserNotFoundException e) {
        return new ErrorMessage(e.getMessage());
    }
}
