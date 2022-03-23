package hu.dia.tacocloud.model.data;

import hu.dia.tacocloud.model.enumeration.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
@Entity
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    @Enumerated(EnumType.STRING)
    private final Type type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Ingredient)) return false;

        Ingredient that = (Ingredient) o;

        return new EqualsBuilder().append(id, that.id).append(name, that.name).append(type, that.type).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(type).toHashCode();
    }
}
