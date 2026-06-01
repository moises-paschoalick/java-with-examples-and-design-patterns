package design.patterns.simpleFactory.framework.dto;

public class NotificationRequestDTO {
    String recipient;
    String message;
    String notificationType;

    public NotificationRequestDTO() {
    }

    public NotificationRequestDTO(String recipient, String message, String notificationType) {
        this.recipient = recipient;
        this.message = message;
        this.notificationType = notificationType;
    }

    public String getRecipeient() {
        return recipient;
    }

    public void setRecipeient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
