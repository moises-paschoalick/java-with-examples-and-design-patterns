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

        PaymentProcessor paymentProcessor;
        Notifier notifier;
        InventoryManager inventoryManager;
        ShippingService shippingService;
    }

    public void processOrder(OrderDetailsDTO orderDetails) {

        this.paymentProcessor.processPayment(orderDetails.getAmount());
        this.notifier.sendConfirmation(orderDetails.getEmail());
        this.inventoryManager.updateStock(orderDetails.getProductId(), orderDetails.getQuantity());
        this.shippingService.initiateShipping(orderDetails);

    }

}
