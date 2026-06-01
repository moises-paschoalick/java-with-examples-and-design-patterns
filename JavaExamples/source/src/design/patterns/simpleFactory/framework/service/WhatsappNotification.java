package design.patterns.simpleFactory.framework.service;

public class WhatsappNotification implements NotificationType {


    @Override
    public void send(String message, String recipient) {

        System.out.println("Via WhatsApp: " +
                "\nmessage:" + message +
                "\nrecipient:" + recipient);
    }
}
