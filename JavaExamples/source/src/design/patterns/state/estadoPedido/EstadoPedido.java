package design.patterns.state.estadoPedido;

import design.patterns.state.Pedido;

public interface EstadoPedido {

     void preparar(Pedido pedido);
     void inicarEntrega(Pedido pedido);
     void finalizarEntrega(Pedido pedido);

}
