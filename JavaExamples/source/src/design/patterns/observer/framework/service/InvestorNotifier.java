package design.patterns.observer.framework.service;

import java.math.BigDecimal;

// classes observadoras
public class InvestorNotifier implements BitcoinPriceObserver {
    @Override
    public BigDecimal update(BigDecimal price) {
        System.out.println(">>> InvestorNotifier recebeu aleraçao de preço para: " + price);
        System.out.println(">>> Enviar notificação para os investidores...");
        return null;
    }
}
