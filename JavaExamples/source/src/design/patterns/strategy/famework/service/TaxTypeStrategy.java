package design.patterns.strategy.famework.service;

import java.math.BigDecimal;

// Essa classe é a estratégia
// ICMS, IPI, ISS é a estratégia concreta
public interface TaxTypeStrategy {

    BigDecimal calculate(BigDecimal amount);

}
