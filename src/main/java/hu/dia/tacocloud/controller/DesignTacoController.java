package hu.dia.tacocloud.controller;

import hu.dia.tacocloud.model.data.Ingredient;
import hu.dia.tacocloud.model.data.Order;
import hu.dia.tacocloud.model.data.Taco;
import hu.dia.tacocloud.model.enumeration.Type;
import hu.dia.tacocloud.service.IngredientService;
import hu.dia.tacocloud.service.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    private final IngredientService ingredientService;
    private final TacoService tacoService;

    public DesignTacoController(IngredientService ingredientService, TacoService tacoService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredientList = new ArrayList<>(ingredientService.findAll());

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredientList, type));
        }

        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredientList, Type type) {
        return ingredientList.stream()
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid Taco designatedTaco, Errors errors,
                                @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }
        tacoService.save(designatedTaco);
        order.addDesign(designatedTaco);
        return "redirect:/orders/current";
    }
}
