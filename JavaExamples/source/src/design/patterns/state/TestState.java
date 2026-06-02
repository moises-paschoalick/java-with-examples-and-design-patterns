package design.patterns.state;

public class TestState {

    public static void main(String[] args) {


        Pedido pedido = new Pedido();
        System.out.println(pedido.getEstado());

        pedido.setEstado("Preparando");
        pedido.setEstado("EntregaIniciada");

        //Get e Setter sem comportamento, fere o
        //princípio básico do OO que é o encapsulamento

        //Tell don't ask
        //Aqui está perguntando qual é o estado

        if(pedido.getEstado() == "EntregaIniciadaa"){ // Caso tiver errado
            System.out.println("Enviar uma notificação para o cliente");
        }

    }


}
