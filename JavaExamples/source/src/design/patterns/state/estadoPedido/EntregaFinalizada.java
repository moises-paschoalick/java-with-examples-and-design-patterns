package design.patterns.state.estadoPedido;

import design.patterns.state.Pedido;

public class EntregaFinalizada implements EstadoPedido {

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue");
    }

    @Override
    public void inicarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue");
    }

    @Override
    public void finalizarEntrega(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue não pode ser cancelado");
    }
}
