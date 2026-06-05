package design.patterns.facade.framework.service;

import java.math.BigDecimal;

public class PaymentProcessor {

    public void processPayment(BigDecimal amount) {
        System.out.println("Pagamento no valor: " + amount + " está sendo processado");
    }
}
