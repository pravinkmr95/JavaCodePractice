package LLDPractice.LiskovSubstitution;

public class Car implements Vehicle{
    @Override
    public int getWheels() {
        return 4;
    }

    @Override
    public Boolean hasEngine() {
        return true;
    }
}
