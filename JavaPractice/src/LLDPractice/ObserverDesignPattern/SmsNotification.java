package LLDPractice.ObserverDesignPattern;

public class SmsNotification implements Notification{
    private String phoneNumber;

    public SmsNotification(String number){
        this.phoneNumber = number;
    }
    @Override
    public void send(int temp) {
        System.out.println("Sending SMS to " + phoneNumber + " currentTemp is " + temp);
    }
}
