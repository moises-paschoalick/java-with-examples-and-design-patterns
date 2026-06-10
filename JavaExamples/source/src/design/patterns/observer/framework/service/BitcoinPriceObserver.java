package design.patterns.observer.framework.service;

import java.math.BigDecimal;

public interface BitcoinPriceObserver {

    BigDecimal update(BigDecimal price);

}
