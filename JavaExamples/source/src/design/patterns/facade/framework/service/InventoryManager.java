package design.patterns.facade.framework.service;

public class InventoryManager {
    public void updateStock(Integer productId, Integer quantity) {
        System.out.println("Baixa estoque produto: " + productId  + " quantidade: " + quantity);
    }
}
