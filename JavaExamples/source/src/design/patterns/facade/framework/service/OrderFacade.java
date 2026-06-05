package design.patterns.facade.framework.service;

import design.patterns.facade.framework.dto.OrderDetailsDTO;

public class OrderFacade {

    private PaymentProcessor paymentProcessor;
    private Notifier notifier;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    // Essa classe OrderFacade encapsula todo o fluxo
    // e todas as regras a respeito do pedido

    public OrderFacade() {
        paymentProcessor = new PaymentProcessor();
        notifier = new Notifier();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }

    public void processOrder(OrderDetailsDTO orderDetails) {
        // ponto polêmico
        // O facade está fazendo coisa de mais
        // S do SOLID (Single responsability)
        // Qual é o único motivo que tem para esa classe mudar?
        // Vai mudar somente se alterar o fluxo do pedido
        this.paymentProcessor.processPayment(orderDetails.getAmount());
        this.notifier.sendConfirmation(orderDetails.getEmail());
        this.inventoryManager.updateStock(orderDetails.getProductId(), orderDetails.getQuantity());
        this.shippingService.initiateShipping(orderDetails);

    }

}
