package LLDPractice.AbstractFactoryDesignPattern;

public class WindowFactory implements ComputerFactory{
    @Override
    public Keyboard createKeyboard() {
        return new WindowKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new WindowMouse();
    }
}
