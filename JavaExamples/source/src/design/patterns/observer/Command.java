package design.patterns.observer;


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

        for(int i=0; i<100; i++) {
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
    }
}
