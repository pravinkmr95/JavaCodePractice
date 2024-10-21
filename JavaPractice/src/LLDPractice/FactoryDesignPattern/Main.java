package LLDPractice.FactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle bike = VehicleFactory.getVehicle("Bike");
        Vehicle car = VehicleFactory.getVehicle("Car");
        System.out.println(bike.numberOfWheels());
        System.out.println(car.numberOfWheels());
    }
}
