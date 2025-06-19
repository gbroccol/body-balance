package org.body.balance.recipe.repository;

import org.body.balance.recipe.domain.dictionary.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {
}
