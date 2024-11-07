package org.body.balance.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.body.balance.recipe.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
public class RecipeControllerV1 {

    private final RecipeService recipeService; // todo fix

    @PostMapping
    public ResponseEntity<Object> save() {
        recipeService.save();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
