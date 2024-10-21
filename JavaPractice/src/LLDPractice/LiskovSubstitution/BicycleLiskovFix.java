package LLDPractice.LiskovSubstitution;

public class BicycleLiskovFix implements EngineLessVehicle{
    @Override
    public int wheels() {
        return 2;
    }
}
