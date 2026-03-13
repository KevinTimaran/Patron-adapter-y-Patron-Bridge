package adapter;

public class LegacySmsSystem {
    public void sendSms(String message, String phoneNumber) {
        System.out.println("Sending SMS from legacy system to " + phoneNumber + ": " + message);
    }
}