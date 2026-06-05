package design.patterns.state.estadoPedido;

import design.patterns.state.Pedido;

public class EntregaIniciada implements EstadoPedido {

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi preparado");
    }

    @Override
    public void inicarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido já saiu para o cliente");
    }

    @Override
    public void finalizarEntrega(Pedido pedido) {
        pedido.setEstado(new EntregaFinalizada());
    }
}
