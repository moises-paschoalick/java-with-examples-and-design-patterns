package design.patterns.state;

public class TestState {

    public static void main(String[] args) {
        /*
        Antes de aplicar o padrão state

        Pedido pedido = new Pedido();
        System.out.println(pedido.getEstado());

        pedido.setEstado("Preparando");
        pedido.setEstado("EntregaIniciada");

        //Get e Setter sem comportamento, fere o
        //princípio básico do OO que é o encapsulamento

        //Tell don't ask (diga não pergunte)
        //Aqui está perguntando qual é o estado

        if(pedido.getEstado() == "EntregaIniciadaa"){ // Caso tiver errado
            System.out.println("Enviar uma notificação para o cliente");
        }*/

        System.out.println("---------- Início ----------------");
        Pedido pedido = new Pedido();
        //pedido.iniciarEntrega(); // Exception
        pedido.preparar();
        pedido.iniciarEntrega();
        pedido.finalizarEntrega();

        System.out.println(pedido.getEstado());

        System.out.println("---------- Teste Cancelar ----------------");

        Pedido pedido2 = new Pedido();
        pedido2.preparar();
        pedido2.cancelarPedido();
        pedido2.iniciarEntrega();

    }




}
