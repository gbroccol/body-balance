package org.body.balance.content.recipe.service;

import lombok.RequiredArgsConstructor;
import org.body.balance.content.recipe.repository.RecipeRepository;
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
