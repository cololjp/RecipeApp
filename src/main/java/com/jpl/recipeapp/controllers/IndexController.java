package com.jpl.recipeapp.controllers;

import com.jpl.recipeapp.model.Recipe;
import com.jpl.recipeapp.model.UnitOfMeasure;
import com.jpl.recipeapp.repositories.RecipeRepository;
import com.jpl.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }

}
