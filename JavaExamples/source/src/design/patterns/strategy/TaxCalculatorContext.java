package design.patterns.strategy;

public class TaxCalculatorContext {

    // Strategy usa a injeção de dependência
    private TaxStrategy strategy;

    public TaxCalculatorContext(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public double  calculate(double amount) {
        return strategy.calculate(amount);
    }

}
