package design.patterns.factoryMethod.refactoryguru;

public class Truck implements Transport{

    String type;

    public Truck() {
        this.type = "Caminhão";
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering by land using truck");
    }
}
