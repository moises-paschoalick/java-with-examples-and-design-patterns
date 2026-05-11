package design.patterns.factorymethod.refactoryguru;

public class SeaLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Ship();
    }


}
