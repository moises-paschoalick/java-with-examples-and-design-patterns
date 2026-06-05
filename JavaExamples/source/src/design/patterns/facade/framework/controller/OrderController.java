package design.patterns.facade.framework.controller;

import design.patterns.facade.framework.dto.OrderDetailsDTO;
import design.patterns.facade.framework.dto.OrderRequestDTO;
import design.patterns.facade.framework.service.*;
import design.patterns.simpleFactory.framework.dto.NotificationRequestDTO;

public class OrderController {

    // Antes facade
    /*
    private PaymentProcessor paymentProcessor;
    private Notifier notifier;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;
     */
    // Depois aplicando o facade
    private OrderFacade orderFacade;

    public OrderController() {
        orderFacade = new OrderFacade();
    }

    //POST("/api/order)
    public void newOrder(OrderRequestDTO request) {

        OrderDetailsDTO orderDetails = request.getOrderDetailsDTO();

        // Antes facade
        /*
        // Controller não pode ter regra de negócio
        // Ele está sabendo muito sobre fluxo
        this.paymentProcessor.processPayment(orderDetails.getAmount());
        this.notifier.sendConfirmation(orderDetails.getEmail());
        this.inventoryManager.updateStock(orderDetails.getProductId(), orderDetails.getQuantity());
        this.shippingService.initiateShipping(orderDetails);
        */

        // Depois aplicando o facade
        this.orderFacade.processOrder(orderDetails);

        System.out.println("Pedido realizado com sucesso");

    }

}
