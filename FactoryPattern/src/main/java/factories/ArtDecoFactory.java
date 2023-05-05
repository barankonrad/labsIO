package factories;

import furnitures.chairs.ArtDecoChair;
import furnitures.chairs.Chair;
import furnitures.coffeeTables.ArtDecoCoffeeTable;
import furnitures.coffeeTables.CoffeeTable;
import furnitures.sofas.ArtDecoSofa;
import furnitures.sofas.Sofa;

public class ArtDecoFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }
}
