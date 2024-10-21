package Optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Animal> animalOptional = getAnimalInfo();
        Animal animal = animalOptional.orElse(new Animal("Unknown", 1));
        if (animalOptional.isPresent()){
            System.out.println(animalOptional.get().getAge());
        } else {
            System.out.println(0);
        }
    }

    public static Optional<Animal> getAnimalInfo(){
        Animal animal = new Animal("catty", 2);
        //animal = null;
        return Optional.ofNullable(animal);
    }
}
