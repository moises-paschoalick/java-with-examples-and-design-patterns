package design.patterns.factorymethod.refactoryguru;

// https://refactoring.guru/design-patterns/factory-method
public class ExampleRefactoryGuru {

    public static void main(String[] args) {
        Logistics logistics;

        logistics = new RoadLogistics();
        logistics.planDelivery();

        logistics = new SeaLogistics();
        logistics.planDelivery();


        // Antes
        /*
        Logistics l = new Logistics("sea");
        System.out.println(l.toString());*/


    }

}
