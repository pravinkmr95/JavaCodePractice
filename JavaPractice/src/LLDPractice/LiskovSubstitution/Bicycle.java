package LLDPractice.LiskovSubstitution;

public class Bicycle implements Vehicle{
    @Override
    public int getWheels() {
        return 0;
    }

    @Override
    public Boolean hasEngine() {
        return null;
    }
}
