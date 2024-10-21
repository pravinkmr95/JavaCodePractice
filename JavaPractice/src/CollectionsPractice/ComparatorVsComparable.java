package CollectionsPractice;

import java.util.*;

public class ComparatorVsComparable {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 0, 44, 90, 56};
        Arrays.sort(arr); // comparable using compareTo
        Arrays.sort(arr, (a, b) -> (b-a));// comparator using compare method, if diff > 0, swap
        System.out.println(Arrays.toString(arr));

        Car[] cars = new Car[4];
        cars[0] = new Car(10, "Sedan");
        cars[1] = new Car(200, "Hatchback");
        cars[2] = new Car(3, "SUV");
        cars[3] = new Car(45, "XUV");
        //Comparator
        Arrays.sort(cars, (car1, car2) -> car1.getName().compareTo(car2.getName()));
        System.out.println(Arrays.toString(cars));
        Arrays.sort(cars, Comparator.comparing(Car::getName));

        // Comparable
        List<Car1> car1List = new ArrayList<>();
        car1List.add(new Car1(10, "Sedan"));
        car1List.add(new Car1(200, "Hatchback"));
        car1List.add(new Car1(3, "SUV"));
        car1List.add(new Car1(45, "XUV"));
        Collections.sort(car1List);
        System.out.println(car1List);
    }
}
