package LLDPractice.ObserverDesignPattern;

public class Main {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification("xyz@test.com");
        Notification smsNotification = new SmsNotification("7239097020");
        WeatherStation weatherStation = new WeatherStation(25);

        weatherStation.addObserver(emailNotification);
        weatherStation.setCurrentTemperature(26);

        weatherStation.setCurrentTemperature(26);

        weatherStation.addObserver(smsNotification);
        weatherStation.setCurrentTemperature(25);

        weatherStation.removeObserver(emailNotification);
        weatherStation.setCurrentTemperature(24);
    }
}
