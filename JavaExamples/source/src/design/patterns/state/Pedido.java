package design.patterns.state;

import design.patterns.state.estadoPedido.*;

public class Pedido {

    /*
    Antes de aplicar o padrão state
    private String estado;


    public Pedido(){
        this.estado = "REALIZADO";
    }

    /*
    Realizado — O pedido foi feito, mas ainda não foi aceito pelo restaurante.
    Preparando — O restaurante aceitou o pedido e está preparando a comida.
    A Caminho — A comida foi preparada e está sendo entregue ao cliente.
    Entregue — A comida foi entregue ao cliente e o pedido está concluído.


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    */

    private EstadoPedido estado;

    public Pedido() {
        this.estado = new Realizado();
    }

    public void preparar() {
        this.estado.preparar(this);
    }

    public void iniciarEntrega() {
        this.estado.inicarEntrega(this);
    }

    public void finalizarEntrega() {
        this.estado.finalizarEntrega(this);
    }

    public void cancelarPedido() {
        this.estado.cancelar(this);
    }


    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public EstadoPedido getEstado() {
        System.out.println("Estado: " + this.estado);
        return this.estado;
    }

}
