package design.patterns.state.estadoPedido;

import design.patterns.state.Pedido;

public class Realizado implements EstadoPedido {

    @Override
    public void preparar(Pedido pedido) {
        pedido.setEstado(new Preparando());
    }

    @Override
    public void inicarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido está sendo realizado");
    }

    @Override
    public void finalizarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido está sendo realizado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new Cancelado());
    }
}
