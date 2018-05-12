package com.jpl.recipeapp.repositories;

import com.jpl.recipeapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Integer> {

    Optional<UnitOfMeasure> findUnitOfMeasureByUnit(String unit);

}
