package design.patterns.simpleFactory.framework.service;

public class SmsNotification implements NotificationType {


    @Override
    public void send(String message, String recipient) {

        System.out.println("Via SMS: " +
                "\nmessage:" + message +
                "\nrecipient:" + recipient);
    }
}
