package com.jpl.recipeapp.repositories;

import com.jpl.recipeapp.model.Difficulty;
import com.jpl.recipeapp.model.Ingredient;
import com.jpl.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Optional<Recipe> findRecipeByName(String name);
    Optional<Recipe> findRecipeByDifficulty(Difficulty difficulty);
    Optional<Recipe> findByIngredients(Ingredient ingredient);

}
