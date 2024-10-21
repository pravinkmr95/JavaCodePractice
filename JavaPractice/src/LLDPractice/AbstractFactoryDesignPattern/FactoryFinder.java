package LLDPractice.AbstractFactoryDesignPattern;

import java.util.Optional;

public class FactoryFinder {
    public static Optional<ComputerFactory> getComputer(String osType){
        ComputerFactory factory;
        if (osType.equalsIgnoreCase("windows")){
            factory =  new WindowFactory();
            return Optional.of(factory);
        } else if (osType.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
            return Optional.of(factory);
        }
        return Optional.empty();
    }
}
