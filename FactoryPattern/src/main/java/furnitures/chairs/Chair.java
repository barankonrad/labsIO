package furnitures.chairs;

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
    @JsonSubTypes.Type(value = ModernChair.class, name = "ModernChair"),
    @JsonSubTypes.Type(value = VictorianChair.class, name = "VictorianChair"),
    @JsonSubTypes.Type(value = ArtDecoChair.class, name = "ArtDecoChair"),
})
public abstract class Chair extends Furniture {

    private final boolean hasAngleRegulation;

    public Chair(int numberOfLegs, double height, double width, double weight, double price, boolean hasAngleRegulation) {
        super(numberOfLegs, height, width, weight, price);
        this.hasAngleRegulation = hasAngleRegulation;
    }
}
