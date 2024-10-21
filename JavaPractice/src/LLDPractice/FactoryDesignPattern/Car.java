package LLDPractice.FactoryDesignPattern;

public class Car implements Vehicle{
    @Override
    public int numberOfWheels() {
        return 4;
    }
}
