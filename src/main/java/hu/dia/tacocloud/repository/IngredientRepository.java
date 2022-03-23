package hu.dia.tacocloud.repository;

import hu.dia.tacocloud.model.data.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
