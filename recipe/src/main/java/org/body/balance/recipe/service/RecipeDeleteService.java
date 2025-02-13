package org.body.balance.recipe.service;

import lombok.RequiredArgsConstructor;
import org.body.balance.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RecipeDeleteService {

    private final RecipeRepository repository;

    @Transactional
    public Integer handleRequest(String id) { // todo какой ответ отдавать лучше не понимаю
        return repository.markAsDeleted(id);
    }
}
