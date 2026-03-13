package bridge;

import java.util.Arrays;
import java.util.List;

public class CompositeChannel implements NotificationChannel {
    private final List<NotificationChannel> channels;

    public CompositeChannel(NotificationChannel... channels) {
        this.channels = Arrays.asList(channels);
    }

    @Override
    public void send(String message) {
        GuiChannel monitorVisual = null;
        for (NotificationChannel channel : channels) {
            if (channel instanceof GuiChannel) {
                monitorVisual = (GuiChannel) channel;
                break;
            }
        }

        for (NotificationChannel channel : channels) {
            channel.send(message);
            if (monitorVisual != null && channel != monitorVisual) {
                monitorVisual.registerDispatch(channel.channelName(), message);
            }
        }
    }
}


