package design.patterns.facade.framework.service;

public class Notifier {
    public void sendConfirmation(String email) {
        System.out.println("Envio de confirmação: " + email + " foi enviado");
    }
}
