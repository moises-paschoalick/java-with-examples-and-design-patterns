package design.patterns.state.estadoPedido;

import design.patterns.state.Pedido;

// caso for adicionar mais um estado vai precisar alterar as classes
// Isso é o ISP sendo violado
// Solução usar classe abstrata e o padrão adapter
public interface EstadoPedido {

     void preparar(Pedido pedido);
     void inicarEntrega(Pedido pedido);
     void finalizarEntrega(Pedido pedido);
     void cancelar(Pedido pedido);
}
