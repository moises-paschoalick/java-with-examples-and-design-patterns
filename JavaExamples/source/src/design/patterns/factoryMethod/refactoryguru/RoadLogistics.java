package design.patterns.factoryMethod.refactoryguru;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }

}
