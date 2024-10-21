package LLDPractice.FactoryDesignPattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String type){
        Vehicle vehicle;
        switch (type){
            case "Car":
                vehicle = new Car();
                break;
            case "Bike":
                vehicle = new Bike();
                break;
            case "Auto":
                vehicle = new Autoricksaw();
                break;
            default:
                vehicle = null;
        }
        return vehicle;
    }
}
