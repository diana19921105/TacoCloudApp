package hu.dia.tacocloud.service.impl;

import hu.dia.tacocloud.model.data.Ingredient;
import hu.dia.tacocloud.repository.IngredientRepository;
import hu.dia.tacocloud.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }
}
