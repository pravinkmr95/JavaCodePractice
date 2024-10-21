package LLDPractice.LiskovSubstitution;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(car);
        vehicleList.add(bicycle);
        for (Vehicle vehicle: vehicleList){
            boolean engine = vehicle.hasEngine(); // cycle returns null causing the null pointer exception
            System.out.println(engine);           // Liskov principal says that a child should minimize the scope of a parent
        }

        System.out.println("After fixing Liskov fix");
        EngineVehicle newCar = new CarLiskovFix();
        VehicleLiskovFix newBicycle = new BicycleLiskovFix();
        newBicycle.wheels();// bicycle can't call has engine
        newCar.hasEngine();
        List<VehicleLiskovFix> vehicleLiskovFixList = new ArrayList<>();
        vehicleLiskovFixList.add(newCar);
        vehicleLiskovFixList.add(newBicycle);
        for (VehicleLiskovFix vehicle: vehicleLiskovFixList){
            //vehicle.hasEngine();
        }
    }
}
