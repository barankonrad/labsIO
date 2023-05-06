package furnitures.coffeeTables;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import furnitures.Furniture;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ModernCoffeeTable.class, name = "ModernCoffeeTable"),
        @JsonSubTypes.Type(value = VictorianCoffeeTable.class, name = "VictorianCoffeeTable"),
        @JsonSubTypes.Type(value = ArtDecoCoffeeTable.class, name = "ArtDecoCoffeeTable"),
})
public abstract class CoffeeTable extends Furniture {

    private final boolean hasDrawers;
    private final double usableSurface;

    public CoffeeTable(int numberOfLegs, double height, double width, double weight, double price, boolean hasDrawers,
            double usableSurface) {
        super(numberOfLegs, height, width, weight, price);
        this.hasDrawers = hasDrawers;
        this.usableSurface = usableSurface;
    }
}
