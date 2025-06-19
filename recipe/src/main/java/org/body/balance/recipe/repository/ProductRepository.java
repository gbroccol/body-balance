package org.body.balance.recipe.repository;

import java.util.UUID;
import org.body.balance.recipe.domain.food.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
