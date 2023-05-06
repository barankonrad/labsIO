package furnitures.sofas;

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
        @JsonSubTypes.Type(value = ModernSofa.class, name = "ModernSofa"),
        @JsonSubTypes.Type(value = VictorianSofa.class, name = "VictorianSofa"),
        @JsonSubTypes.Type(value = ArtDecoSofa.class, name = "ArtDecoSofa"),
})
public abstract class Sofa extends Furniture {
    private final int numberOfSittingPlaces;
    private final boolean hasSleepingFunction;

    public Sofa(int numberOfLegs, double height, double width, double weight, double price, int numberOfSittingPlaces,
            boolean hasSleepingFunction) {
        super(numberOfLegs, height, width, weight, price);
        this.numberOfSittingPlaces = numberOfSittingPlaces;
        this.hasSleepingFunction = hasSleepingFunction;
    }
}
