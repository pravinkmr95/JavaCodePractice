package LLDPractice.LiskovSubstitution;

public class CarLiskovFix implements EngineVehicle{
    @Override
    public int wheels() {
        return 4;
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
