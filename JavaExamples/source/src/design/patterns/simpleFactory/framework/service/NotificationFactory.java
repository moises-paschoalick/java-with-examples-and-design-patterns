package design.patterns.simpleFactory.framework.service;

public interface NotificationFactory {

    // Método Stático (cuidado ao usar, principalmente para teste unitários)
    static NotificationType create(String notificationType) {

        if(notificationType.equals("email")) {
            return new EmailNotification();
        }

        if(notificationType.equals("sms")) {
            return new SmsNotification();
        }

        if(notificationType.equals("slack")) {
            return new SlackNotification();
        }

        // Desantagem do Simple Factory:
        // Fere o Open Closed Principle (Aberto para extensão, fechado para modificação)
        // Caso precise adicionar mais um tipo

        if(notificationType.equals("whatsapp")) {
            return new WhatsappNotification();
        }

        throw new IllegalArgumentException("Invalid NotificationType");

    }


}
