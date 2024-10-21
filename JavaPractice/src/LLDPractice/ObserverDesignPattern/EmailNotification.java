package LLDPractice.ObserverDesignPattern;

public class EmailNotification implements Notification{
    private String email;

    public EmailNotification(String mail){
        this.email = mail;
    }

    @Override
    public void send(int temp) {
        System.out.println("Sending mail to " + email + ". Current temp is " + temp);
    }
}
