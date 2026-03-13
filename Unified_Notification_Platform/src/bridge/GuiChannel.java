package bridge;

import ui.NotificationFrame;

public class GuiChannel implements NotificationChannel {
    private final NotificationFrame frame = NotificationFrame.getInstance();

    @Override
    public void send(String message) {
        frame.showMessage("SENT VIA Screen: " + message);
    }

    public void registerDispatch(String channel, String message) {
        frame.showMessage("SENT VIA " + channel + ": " + message);
    }

    @Override
    public String channelName() {
        return "Screen";
    }
}

