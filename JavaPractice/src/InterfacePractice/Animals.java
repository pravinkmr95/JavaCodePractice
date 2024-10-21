package InterfacePractice;

public class Animals implements Dog, Cow{

    @Override
    public int legs() {
        return Dog.super.legs();
    }
}
