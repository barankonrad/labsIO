package factories;

import furnitures.chairs.ArtDecoChair;
import furnitures.coffeeTables.ArtDecoCoffeeTable;
import furnitures.sofas.ArtDecoSofa;

public class ArtDecoFactory implements FurnitureFactory {
    @Override
    public ArtDecoChair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public ArtDecoCoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }

    @Override
    public ArtDecoSofa createSofa() {
        return new ArtDecoSofa();
    }
}
