package design.patterns.facade.framework.dto;

import java.math.BigDecimal;

public class OrderRequestDTO {

    OrderDetailsDTO orderDetailsDTO;

    public OrderDetailsDTO getOrderDetailsDTO() {
        return orderDetailsDTO;
    }

    public void setOrderDetailsDTO(OrderDetailsDTO orderDetailsDTO) {
        this.orderDetailsDTO = orderDetailsDTO;
    }
}
