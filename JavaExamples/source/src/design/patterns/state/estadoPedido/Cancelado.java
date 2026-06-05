package design.patterns.state.estadoPedido;

import design.patterns.state.Pedido;

public class Cancelado implements EstadoPedido{


    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode ser preparado pois foi cancelado");
    }

    @Override
    public void inicarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode sair para entrega pois foi cancelado");
    }

    @Override
    public void finalizarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode ser finalizado pos foi cancelado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        //pedido.setEstado(new Cancelado()); // erro
        throw new IllegalStateException("Pedido já está cancelado");
    }
}
