package design.patterns.observer;

import design.patterns.observer.framework.service.BitcoinPriceObserver;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Bitcoin {

    private BigDecimal price;
    private List<BitcoinPriceObserver> observers;

    // padrão Observer tem duas partes
    // Observable -> observável, objeto que está sendo observado.
    // Observer -> observadores (classes de serviços)


    public Bitcoin() {
        this.price = new BigDecimal(0);
        this.observers = new ArrayList<>();
    }

    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal newPrice) {
        if(newPrice != this.price){
            System.out.println("Alterou o preço Bitcoin de: " + this.price + " para: " + newPrice);
            this.price = newPrice;
            this.notifyObservers();
        }
    }

    public void addObservers(BitcoinPriceObserver observer) {
        this.observers.add(observer);
    }

    private void notifyObservers() {
        for (BitcoinPriceObserver observer: observers) {
            observer.update(this.price);
        }

    }


}
