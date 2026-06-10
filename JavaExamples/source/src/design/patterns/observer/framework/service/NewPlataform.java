package design.patterns.observer.framework.service;

import java.math.BigDecimal;

// classes observadoras
public class NewPlataform implements BitcoinPriceObserver {


    @Override
    public BigDecimal update(BigDecimal price) {
        System.out.println(">>> NewPlataform recebeu aleraçao de preço para: " + price);
        System.out.println(">>> Atualiza plataforma de notícias");
        return null;

    }
}
