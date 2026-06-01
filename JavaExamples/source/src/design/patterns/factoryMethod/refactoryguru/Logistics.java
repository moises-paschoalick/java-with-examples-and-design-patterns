package design.patterns.factoryMethod.refactoryguru;

abstract class Logistics {

    Transport transport;
    // Factory Method
    public abstract Transport createTransport();

    public void planDelivery() {
        // A classe abstrata NÃO SABE qual transporte será criado.
        Transport transport = createTransport();
        transport.deliver();
    }

    // Antes vários if
    /*
    public  Logistic(String type) {

        if (type.equals("road")) {
            transport = new Truck();
        }

        if (type.equals("sea")) {
            transport = new Ship();
        }

    }*/

    @Override
    public String toString() {
        return "Logistic{" +
                "transport=" + transport.type() +
                '}';
    }
}