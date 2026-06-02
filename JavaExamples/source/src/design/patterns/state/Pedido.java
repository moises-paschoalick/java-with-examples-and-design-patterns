package design.patterns.state;

public class Pedido {

    private String estado;

    public Pedido(){
        this.estado = "REALIZADO";
    }

    /*
    Realizado — O pedido foi feito, mas ainda não foi aceito pelo restaurante.
    Preparando — O restaurante aceitou o pedido e está preparando a comida.
    A Caminho — A comida foi preparada e está sendo entregue ao cliente.
    Entregue — A comida foi entregue ao cliente e o pedido está concluído.
     */

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
