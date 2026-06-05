package design.patterns.facade.framework;

import design.patterns.facade.framework.controller.OrderController;
import design.patterns.facade.framework.dto.OrderDetailsDTO;
import design.patterns.facade.framework.dto.OrderRequestDTO;

import java.math.BigDecimal;

public class TestFacade {


    public static void main(String[] args) {

        OrderController orderController = new OrderController();

        OrderRequestDTO order = new OrderRequestDTO();
        OrderDetailsDTO orderDetails = new OrderDetailsDTO();
            orderDetails.setProductId(1);
            orderDetails.setAmount(new BigDecimal(1000));
            orderDetails.setQuantity(100);
            orderDetails.setEmail("email@gmail.com");
        order.setOrderDetailsDTO(orderDetails);

        orderController.newOrder(order);

    }

}
