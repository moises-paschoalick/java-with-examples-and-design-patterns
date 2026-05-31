package design.patterns.strategy.famework.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ICMS implements TaxTypeStrategy {

    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return amount
                .multiply(BigDecimal.valueOf(4))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
