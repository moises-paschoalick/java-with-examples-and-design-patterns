package design.patterns.observer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

// Simula uma requisição na Binance
public class BinanceApi {

    public BigDecimal getLastPrice() {

       // Exatamente 2 casas decimais
        BigDecimal numero = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(0, 10000))
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("---- recuperando preço Bitcoin -----");
        System.out.println(numero);
        return numero;
    }

}
