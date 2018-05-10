package com.jpl.recipeapp.model;

import java.util.List;

public class Recipe {

    private Byte[] image;
    private String name;
    private String description;
    private Difficulty difficulty;
    private List<Ingredient> ingredients;
    private List<String> instructions;
    private List<String> tags;

}
