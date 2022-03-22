package hu.dia.tacocloud.model.data;

import hu.dia.tacocloud.model.enumeration.Type;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;
}
