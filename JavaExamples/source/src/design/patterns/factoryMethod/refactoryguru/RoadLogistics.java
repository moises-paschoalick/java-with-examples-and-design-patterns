package design.patterns.factorymethod.refactoryguru;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }

}
