package design.patterns.observer;


import design.patterns.observer.framework.service.BitcoinPriceLogger;
import design.patterns.observer.framework.service.BitcoinPriceObserver;
import design.patterns.observer.framework.service.InvestorNotifier;
import design.patterns.observer.framework.service.NewPlataform;

import java.math.BigDecimal;

// um batch que fica em tempo em tempo atualizando o preço
// do bitcon (simular o problema)
public class Command {

    public static void main(String[] args) {
        callCommand();


    }

    private static void callCommand() {
        Bitcoin bitcoin = new Bitcoin();
        BinanceApi binanceApi = new BinanceApi();

        // Antes de aplicar. Precisa ir na api de tempos em tempos
        /*for(int i=0; i<100; i++) {
            BigDecimal price = binanceApi.getLastPrice();
            bitcoin.setPrice(price);

            // nova regra de negócio
            // toda vez que for atualizar o preço do bitcoin
            // precisa analizar o log
            // enviar notificação para os investidores
            // atualizar na plataforma de notícias
            // faria varios if
            // log
            // notificação para o usuário
            // plataforma...
        }
         */

        bitcoin.addObservers(new BitcoinPriceLogger());
        bitcoin.addObservers(new InvestorNotifier());
        bitcoin.addObservers(new NewPlataform());

        // Programando reativamente (os observadores reagem ao um evento que aconteceu no bitcoin)
        // Código mais elegante
        // Código mais escalável e performático
        // A cada nova classe de serviço que precisar executar algo
        // todas as vezes que o bitcoin for atualizado
        // 1 - somente cria uma classe nova (uma boa prática, respeita o S do SOLID
        //   - Também respeita o O do SOLID (open closed)
        // somente adicionar mais um observador e não mais ifs.

        BigDecimal price = binanceApi.getLastPrice();
        bitcoin.setPrice(price);

    }
}
