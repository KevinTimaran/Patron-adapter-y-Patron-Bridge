package bridge;


public abstract class Message {
    protected NotificationChannel channel;

    public Message(NotificationChannel channel) {
        this.channel = channel;
    }

    public abstract void sendNotification(String title, String body);
}
