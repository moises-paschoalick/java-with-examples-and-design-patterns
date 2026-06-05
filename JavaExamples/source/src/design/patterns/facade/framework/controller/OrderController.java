package design.patterns.facade.framework.controller;

import design.patterns.facade.framework.dto.OrderDetailsDTO;
import design.patterns.facade.framework.dto.OrderRequestDTO;
import design.patterns.facade.framework.service.InventoryManager;
import design.patterns.facade.framework.service.Notifier;
import design.patterns.facade.framework.service.PaymentProcessor;
import design.patterns.facade.framework.service.ShippingService;
import design.patterns.simpleFactory.framework.dto.NotificationRequestDTO;

public class OrderController {

    private PaymentProcessor paymentProcessor;
    private Notifier notifier;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    //POST("/api/order)
    public void newOrder(OrderRequestDTO request) {

        OrderDetailsDTO orderDetails = request.getOrderDetailsDTO();

        // Controller não pode ter regra de negócio
        // Ele está sabendo muito sobre fluxo
        this.paymentProcessor.processPayment(orderDetails.getAmount());
        this.notifier.sendConfirmation(orderDetails.getEmail());
        this.inventoryManager.updateStock(orderDetails.getProductId(), orderDetails.getQuantity());
        this.shippingService.initiateShipping(orderDetails);


        System.out.println("Pedido realizado com sucesso");

    }

}
