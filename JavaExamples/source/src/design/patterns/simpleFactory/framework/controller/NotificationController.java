package design.patterns.simpleFactory.framework.controller;

import design.patterns.simpleFactory.framework.dto.NotificationRequestDTO;
import design.patterns.simpleFactory.framework.service.*;

public class NotificationController {


    //POST("/api/send-notification)
    public void sendNotification(NotificationRequestDTO request) {

        String notificationType = request.getNotificationType();
        String recipient = request.getRecipeient();
        String message = request.getMessage();

        //NotificationType notification = null;

        // Leva a lógica para factory
        /*
        if(notificationType.equals("email")) {
            notification = new EmailNotification();
        }

        if(notificationType.equals("sms")) {
            notification = new SmsNotification();
        }

        if(notificationType.equals("slack")) {
            notification = new SlackNotification();
        }
         */

        NotificationType notification = NotificationFactory.create(notificationType);
        notification.send(message, recipient);
        //return new Response("Notification enviado com sucesso");
        System.out.println("Notification enviado com sucesso");
    }

}
