package factories;

import furnitures.chairs.Chair;
import furnitures.coffeeTables.CoffeeTable;
import furnitures.sofas.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    CoffeeTable createCoffeeTable();
    Sofa createSofa();
}
