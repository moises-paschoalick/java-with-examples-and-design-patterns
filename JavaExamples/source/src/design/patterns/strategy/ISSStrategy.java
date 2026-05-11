package design.patterns.strategy;

public class ISSStrategy implements TaxStrategy {

    @Override
    public double calculate(double amount) {
        return amount * 11 / 100;
    }

}
