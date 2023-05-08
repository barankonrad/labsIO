package furnitures;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import furnitures.chairs.Chair;
import furnitures.coffeeTables.CoffeeTable;
import furnitures.sofas.Sofa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Chair.class, name = "Chair"),
        @JsonSubTypes.Type(value = Sofa.class, name = "Sofa"),
        @JsonSubTypes.Type(value = CoffeeTable.class, name = "CoffeeTable")
})
public abstract class Furniture {
    private final double height;
    private final double width;
    private final double weight;
    private final double price;
    private final int numberOfLegs;

    public Furniture(int numberOfLegs, double height, double width, double weight, double price) {
        this.numberOfLegs = numberOfLegs;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.price = price;
    }
}
