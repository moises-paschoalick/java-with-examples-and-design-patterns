package design.patterns.simpleFactory.framework;

import design.patterns.simpleFactory.framework.controller.NotificationController;
import design.patterns.simpleFactory.framework.dto.NotificationRequestDTO;

public class TestSimpleFactory {

    public static void main(String[] args) {

        NotificationController notificationController = new NotificationController();
        NotificationRequestDTO requestDTO = new NotificationRequestDTO();
        requestDTO.setRecipeient("@joao.silva");
        requestDTO.setMessage("Olá essa é a mensagem");
        //requestDTO.setNotificationType("slack");
        //requestDTO.setNotificationType("sms");
        requestDTO.setNotificationType("whatsapp");

        notificationController.sendNotification(requestDTO);

    }

}
