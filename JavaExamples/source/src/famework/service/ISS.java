package famework.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ISS implements TaxTypeStrategy {

    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return amount
                .multiply(BigDecimal.valueOf(11))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
