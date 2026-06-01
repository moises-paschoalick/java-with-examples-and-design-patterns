package design.patterns.simpleFactory.framework.controller;

import design.patterns.simpleFactory.framework.dto.NotificationRequestDTO;
import design.patterns.simpleFactory.framework.service.EmailNotification;
import design.patterns.simpleFactory.framework.service.NotificationType;
import design.patterns.simpleFactory.framework.service.SlackNotification;
import design.patterns.simpleFactory.framework.service.SmsNotification;

public class NotificationController {


    //POST("/api/send-notification)
    public void sendNotification(NotificationRequestDTO request) {

        String notificationType = request.getNotificationType();
        String recipient = request.getRecipeient();
        String message = request.getMessage();

        NotificationType notification = null;

        if(notificationType.equals("email")) {
            notification = new EmailNotification();
        }

        if(notificationType.equals("sms")) {
            notification = new SmsNotification();
        }

        if(notificationType.equals("slack")) {
            notification = new SlackNotification();
        }

        notification.send(message, recipient);

        //return new Response("Notification enviado com sucesso");
        System.out.println("Notification enviado com sucesso");

    }

}
