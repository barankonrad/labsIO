package factories;

import furnitures.chairs.VictorianChair;
import furnitures.coffeeTables.VictorianCoffeeTable;
import furnitures.sofas.VictorianSofa;

public class VictorianFactory implements FurnitureFactory{
    @Override
    public VictorianChair createChair() {
        return new VictorianChair();
    }

    @Override
    public VictorianCoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public VictorianSofa createSofa() {
        return new VictorianSofa();
    }
}
