package LLDPractice.AbstractFactoryDesignPattern;

public class WindowMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Functioning of Window mouse");
    }
}
