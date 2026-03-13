import adapter.SmsAdapter;
import bridge.CompositeChannel;
import bridge.CriticalMessage;
import bridge.EmailChannel;
import bridge.GuiChannel;
import bridge.Message;
import java.awt.GraphicsEnvironment;

public class Main {
    public static void main(String[] args) {
        Message alert;
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Headless mode detected: visual screen is not shown.");
            alert = new CriticalMessage(new CompositeChannel(new EmailChannel(), new SmsAdapter()));
        } else {
            alert = new CriticalMessage(
                    new CompositeChannel(new EmailChannel(), new SmsAdapter(), new GuiChannel())
            );
        }

        alert.sendNotification("Security", "Someone entered through the main door");
        alert.sendNotification("Server", "CPU usage is above threshold");
        alert.sendNotification("Inventory", "Critical stock level at central warehouse");
    }
}