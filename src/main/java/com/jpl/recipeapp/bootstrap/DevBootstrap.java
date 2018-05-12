package com.jpl.recipeapp.bootstrap;

import com.jpl.recipeapp.model.Difficulty;
import com.jpl.recipeapp.model.Ingredient;
import com.jpl.recipeapp.model.Recipe;
import com.jpl.recipeapp.model.UnitOfMeasure;
import com.jpl.recipeapp.repositories.RecipeRepository;
import com.jpl.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        UnitOfMeasure gr = unitOfMeasureRepository.findUnitOfMeasureByUnit("cc").get();
        UnitOfMeasure toTaste = unitOfMeasureRepository.findUnitOfMeasureByUnit("to taste").get();
        UnitOfMeasure tbsp = unitOfMeasureRepository.findUnitOfMeasureByUnit("tbsp").get();
        UnitOfMeasure cc = unitOfMeasureRepository.findUnitOfMeasureByUnit("cc").get();

        Ingredient water = new Ingredient("Water", 350.0, cc);
        Ingredient salt = new Ingredient("Salt", 14.0, gr);
        Ingredient oil = new Ingredient("Oil", 0.0, toTaste);
        Ingredient oliveOil = new Ingredient("Olive Oil", 0.0, toTaste);
        Ingredient yeast = new Ingredient("Yeast", 40.0, gr);
        Ingredient flour = new Ingredient("Flour", 700.0, gr);
        Ingredient tomatoSauce = new Ingredient("Tomato Sauce", 1.0, tbsp);
        Ingredient mozzarella = new Ingredient("Mozzarella", 200.0, gr);

        String[] pizzaDoughInstructions = {"Dough",
                "Dissolve the yeast with warm water",
                "In a bowl mix the flour and the salt",
                "Add the yeast and warm water until it forms a smooth dough bun",
                "Cover with a cloth and let it rest in a warm place until it doubles its volume",
                "Separate the dough in 4 buns and stretch over the floured countertop until form" +
                        "a disc of desired diameter and thickness",
                "Arrange in previously oiled pizzeras"};
        String[] tomatoSauceInstructions = {"Tomato sauce",
                "Drain the tomatoes and mash",
                "Season with salt, pepper, olive oil and oregano"};
        String[] mozzaPizzaInstructions = {"Grate the mozzarella",
                "Cover the dough with tomato sauce and mozzarella",
                "Cook in the heated oven for about 10 minutes"};
        String[] whitePizzaInstructions = {"Grate the mozzarella",
                "Cover the dough with mozzarella and cook in the heated oven for about 10 minutes",
                "Top with the ham pieces, rucula and sprinkle with olive oil"};

        List<String> pizzaInstructions = new ArrayList<>();
        pizzaInstructions.addAll(Arrays.asList(pizzaDoughInstructions));
        pizzaInstructions.addAll(Arrays.asList(tomatoSauceInstructions));
        pizzaInstructions.addAll(Arrays.asList(mozzaPizzaInstructions));

        Set<Ingredient> mozzarellaPizzaIngredients = new HashSet<>();
        Collections.addAll(mozzarellaPizzaIngredients, water, salt, oil, yeast, flour, mozzarella, oliveOil, tomatoSauce);

        Recipe mozzarellaPizzaRecipe = new Recipe();
        mozzarellaPizzaRecipe.setName("Classic Pizza");
        mozzarellaPizzaRecipe.setDescription("The famous and classic Mozzarella Pizza, super crispy and crunchy, and of course a lot of cheese");
        mozzarellaPizzaRecipe.setInstructions(pizzaInstructions);
        mozzarellaPizzaRecipe.setIngredients(mozzarellaPizzaIngredients);
        mozzarellaPizzaRecipe.setDifficulty(Difficulty.MEDIUM);
        mozzarellaPizzaRecipe.setSource("El Gourmet");
        mozzarellaPizzaRecipe.setUrl("http://elgourmet.com/receta/pizzas-3");

        recipeRepository.save(mozzarellaPizzaRecipe);

        Ingredient water2 = new Ingredient("Water", 350.0, cc);
        Ingredient salt2 = new Ingredient("Salt", 14.0, gr);
        Ingredient oil2 = new Ingredient("Oil", 0.0, toTaste);
        Ingredient oliveOil2 = new Ingredient("Olive Oil", 0.0, toTaste);
        Ingredient yeast2 = new Ingredient("Yeast", 40.0, gr);
        Ingredient flour2 = new Ingredient("Flour", 700.0, gr);
        Ingredient ham = new Ingredient("Ham", 100.0, gr);
        Ingredient mozzarella2 = new Ingredient("Mozzarella", 250.0, gr);
        Ingredient rucula = new Ingredient("Rucula", 50.0, gr);

        List<String> pizzaInstructions2 = new ArrayList<>();
        pizzaInstructions2.addAll(Arrays.asList(pizzaDoughInstructions));
        pizzaInstructions2.addAll(Arrays.asList(whitePizzaInstructions));

        Set<Ingredient> whitePizzaIngredients = new HashSet<>();
        Collections.addAll(whitePizzaIngredients, water2, salt2, oil2, yeast2, flour2, mozzarella2, oliveOil2, ham, rucula);

        Recipe whitePizzaRecipe = new Recipe();
        whitePizzaRecipe.setName("White Pizza");
        whitePizzaRecipe.setDescription("White Pizza is a variant with no sauce, but with Ham and Rucula");
        whitePizzaRecipe.setInstructions(pizzaInstructions2);
        whitePizzaRecipe.setIngredients(whitePizzaIngredients);
        whitePizzaRecipe.setDifficulty(Difficulty.MEDIUM);
        whitePizzaRecipe.setSource("El Gourmet");
        whitePizzaRecipe.setUrl("http://elgourmet.com/receta/pizzas-3");

        recipeRepository.save(whitePizzaRecipe);

    }

}
