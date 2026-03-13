package bridge;

public class CriticalMessage extends Message {
    public CriticalMessage(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void sendNotification(String title, String body) {
        channel.send("!!! CRITICAL ALERT: " + title + " - " + body);
    }
}
