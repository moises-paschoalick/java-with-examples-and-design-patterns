package design.patterns.factorymethod.refactoryguru;

public class Ship implements Transport{

    String type;

    public Ship() {
        this.type = "Navio";
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public void delivery() {
        System.out.println("Delivering by land using ship");
    }

}
