package bridge;

public interface NotificationChannel {
    void send(String message);

    default String channelName() {
        return getClass().getSimpleName();
    }
}

