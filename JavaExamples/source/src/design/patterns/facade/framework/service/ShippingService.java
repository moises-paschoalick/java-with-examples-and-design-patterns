package design.patterns.facade.framework.service;

import design.patterns.facade.framework.dto.OrderDetailsDTO;

public class ShippingService {
    public void initiateShipping(OrderDetailsDTO orderDetails) {
        System.out.println("Produto foi enviado: " + orderDetails);
    }
}
