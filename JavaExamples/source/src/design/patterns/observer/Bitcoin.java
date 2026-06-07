package design.patterns.observer;

import java.math.BigDecimal;

public class Bitcoin {

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal newPrice) {
        if(newPrice != this.price){
            System.out.println("Alterou o preço Bitcoin de: " + this.price + " para: " + newPrice);
            this.price = newPrice;
        }

    }
}
