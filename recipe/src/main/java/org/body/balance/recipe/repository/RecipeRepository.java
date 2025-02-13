package org.body.balance.recipe.repository;

import org.body.balance.recipe.domain.food.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends JpaRepository<Recipe, String> {

    @Modifying
    @Query("UPDATE Recipe r SET r.deleteDt = now() WHERE r.recipeId = :id AND r.deleteDt IS NULL") // todo cron для удаления
    int markAsDeleted(@Param("id") String id);

    Page<Recipe> findByDeleteDtIsNull(Pageable pageable);

}
