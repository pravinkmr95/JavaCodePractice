package LLDPractice.AbstractFactoryDesignPattern;

public class MacFactory implements ComputerFactory{
    @Override
    public Keyboard createKeyboard() {
        return new MacKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new MacMouse();
    }
}
