package factories;

import furnitures.chairs.Chair;
import furnitures.chairs.VictorianChair;
import furnitures.coffeeTables.CoffeeTable;
import furnitures.coffeeTables.VictorianCoffeeTable;
import furnitures.sofas.Sofa;
import furnitures.sofas.VictorianSofa;

public class VictorianFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
