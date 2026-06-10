package design.patterns.observer.framework.service;

import java.math.BigDecimal;

// classes observadoras
public class BitcoinPriceLogger implements BitcoinPriceObserver {

    @Override
    public BigDecimal update(BigDecimal price) {
        System.out.println(">>> BitCoinPriceLoger recebeu aleraçao de preço para: " + price);
        System.out.println(">>> Inicia o processo de análise de logs");

        return null;
    }
}
