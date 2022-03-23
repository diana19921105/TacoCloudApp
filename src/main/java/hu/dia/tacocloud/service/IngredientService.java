package hu.dia.tacocloud.service;

import hu.dia.tacocloud.model.data.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
}
