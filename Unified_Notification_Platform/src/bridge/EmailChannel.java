package bridge;

public class EmailChannel implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }

    @Override
    public String channelName() {
        return "Email";
    }
}

