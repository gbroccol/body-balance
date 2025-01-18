package org.body.balance.recipe.repository;

import org.body.balance.recipe.domain.food.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
