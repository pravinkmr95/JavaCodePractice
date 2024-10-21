package LLDPractice.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private int currentTemperature;
    private List<Notification> notificationList;

    public WeatherStation(int temp){
        this.currentTemperature = temp;
        notificationList = new ArrayList<>();
    }

    public WeatherStation(){
        this.currentTemperature = 0;
        notificationList = new ArrayList<>();
    }

    protected int getCurrentTemperature(){
        return this.currentTemperature;
    }

    protected void sendNotifications(){
        for (Notification notification: notificationList){
            notification.send(currentTemperature);
        }
    }


    public void setCurrentTemperature(int temperature){
        if (temperature != currentTemperature){
            this.currentTemperature = temperature;
            sendNotifications();
        }
    }

    public void addObserver(Notification observer){
        this.notificationList.add(observer);
    }

    public void removeObserver(Notification observer){
        this.notificationList.remove(observer);
    }
}
