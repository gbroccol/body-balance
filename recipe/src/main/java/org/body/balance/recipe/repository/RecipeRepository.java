package org.body.balance.recipe.repository;

import org.body.balance.recipe.domain.food.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    @Modifying
    @Query("UPDATE Recipe r SET r.deletedAt = now() WHERE r.id = :id AND r.deletedAt IS NULL") // todo cron для удаления
    int markAsDeleted(@Param("id") UUID id); // todo Return value of the method is never used

    Page<Recipe> findByDeletedAtIsNull(Pageable pageable);

}
