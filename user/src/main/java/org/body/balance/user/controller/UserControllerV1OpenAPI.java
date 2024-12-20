package org.body.balance.user.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.body.balance.user.dto.UserDtoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "User API - Definition ", version = "1", description = "Operations to get info about users"))
public interface UserControllerV1OpenAPI {

    @Operation(summary = "Get list of all users")
    ResponseEntity<List<UserDtoResponse>> getAllUsers(@Parameter(description = "number of page") Integer page,
                                                      @Parameter(description = "amount of users to display per page") Integer size);

    // todo ВОПРОС - @ApiResponse выглядит лишним - это хорошая практика добавлять такое?
    //      @Schema(implementation = UserDtoResponse.class) - вот это не нравится, ответ поменяем а тут забудем и будет не красиво или это решается тем что текущие апи не меняем, только новые создаем?
    @Operation(summary = "Get user's info by username")
    @ApiResponse(responseCode = "200", description = "OK. User was found",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDtoResponse.class))})
    ResponseEntity<UserDtoResponse> getUserByUsername(@Parameter(description = "name of user") String username);
}
