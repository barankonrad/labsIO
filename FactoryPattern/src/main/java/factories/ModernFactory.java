package factories;

import furnitures.chairs.ModernChair;
import furnitures.coffeeTables.ModernCoffeeTable;
import furnitures.sofas.ModernSofa;

public class ModernFactory implements FurnitureFactory {
    @Override
    public ModernChair createChair() {
        return new ModernChair();
    }

    @Override
    public ModernCoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public ModernSofa createSofa() {
        return new ModernSofa();
    }
}
