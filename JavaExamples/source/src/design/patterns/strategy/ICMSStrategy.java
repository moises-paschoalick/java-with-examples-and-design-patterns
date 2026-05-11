package design.patterns.strategy;

public class ICMSStrategy implements TaxStrategy {

    @Override
    public double calculate(double amount) {
        return amount * 4 / 100;
    }

}
