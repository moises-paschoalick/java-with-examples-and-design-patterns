package design.patterns.strategy;

public class CodigoComStrategy {


    public static void main(String[] args) {

        TaxStrategy icms = new ICMSStrategy();

        TaxCalculatorContext context = new TaxCalculatorContext(icms);

        double result = context.calculate(1000);
        System.out.println(result);

    }
}
