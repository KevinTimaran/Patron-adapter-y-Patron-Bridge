package adapter;

import bridge.NotificationChannel;

public class SmsAdapter implements NotificationChannel {
    private final LegacySmsSystem legacySystem = new LegacySmsSystem();

    @Override
    public void send(String message) {
        legacySystem.sendSms(message, "555-1234");
    }

    @Override
    public String channelName() {
        return "SMS";
    }
}