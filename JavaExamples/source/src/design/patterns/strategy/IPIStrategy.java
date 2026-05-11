package design.patterns.strategy;

public class IPIStrategy implements TaxStrategy {

    @Override
    public double calculate(double amount) {
        return amount * 15 / 100;
    }

}
