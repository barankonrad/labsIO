package factories;

import furnitures.chairs.Chair;
import furnitures.chairs.ModernChair;
import furnitures.coffeeTables.CoffeeTable;
import furnitures.coffeeTables.ModernCoffeeTable;
import furnitures.sofas.ModernSofa;
import furnitures.sofas.Sofa;

public class ModernFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
