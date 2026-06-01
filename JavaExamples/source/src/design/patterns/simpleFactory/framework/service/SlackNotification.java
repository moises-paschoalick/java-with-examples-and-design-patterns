package design.patterns.simpleFactory.framework.service;

public class SlackNotification implements NotificationType {


    @Override
    public void send(String message, String recipient) {

        System.out.println("Via Slack: " +
                "\nmessage:" + message +
                "\nrecipient:" + recipient);
    }
}
