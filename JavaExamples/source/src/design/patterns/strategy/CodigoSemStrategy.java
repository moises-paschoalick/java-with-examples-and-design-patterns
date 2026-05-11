package design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CodigoSemStrategy {

    public static void main(String[] args) {

        BigDecimal amount = new BigDecimal(100.00);
        System.out.println(calculate(amount, "ICMS"));

    }

    public static  BigDecimal calculate(BigDecimal amount, String taxType) {

        if (taxType.equals("ICMS")) {
            return calculatePercent(amount, 4);
            /*return amount
                    .multiply(BigDecimal.valueOf(4))
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);*/
        }

        if (taxType.equals("ISS")) {
            return calculatePercent(amount, 11);
            /*return amount
                    .multiply(BigDecimal.valueOf(11))
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);*/
        }

        if (taxType.equals("IPI")) {
            return calculatePercent(amount, 15);
            /*return amount
                    .multiply(BigDecimal.valueOf(15))
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);*/
        }

        throw new IllegalArgumentException("Invalid tax type");

    }

    private static BigDecimal calculatePercent(BigDecimal amount, int percent) {
        return amount
                .multiply(BigDecimal.valueOf(percent))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

}
