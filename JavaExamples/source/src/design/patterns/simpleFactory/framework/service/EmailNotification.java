package design.patterns.simpleFactory.framework.service;

public class EmailNotification implements NotificationType {


    @Override
    public void send(String message, String recipient) {

        System.out.println("Via email: " +
                "\nmessage:" + message +
                "\nrecipient:" + recipient);
    }
}
