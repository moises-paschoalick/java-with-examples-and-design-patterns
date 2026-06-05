package design.patterns.state.estadoPedido;

import design.patterns.state.Pedido;

public class Preparando implements EstadoPedido {

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está sendo preparado");
    }

    @Override
    public void inicarEntrega(Pedido pedido) {
        pedido.setEstado(new EntregaIniciada());
    }

    @Override
    public void finalizarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode ser finalizado pois ainda está sendo preparado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new Cancelado());
    }
}
