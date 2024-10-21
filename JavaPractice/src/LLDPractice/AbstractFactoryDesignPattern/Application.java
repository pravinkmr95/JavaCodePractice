package LLDPractice.AbstractFactoryDesignPattern;


import java.util.Optional;

public class Application {
    private Mouse mouse;
    private Keyboard keyboard;
    public Application(Keyboard keyboard, Mouse mouse){
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
    public void render(){
        this.mouse.click();
        this.keyboard.pressKeys();
    }

    public static void main(String[] args) {
        ComputerFactory computerFactory;
        String osType = "windows";
        Optional<ComputerFactory> computerFactoryOptional = FactoryFinder.getComputer(osType);
        if (computerFactoryOptional.isPresent()){
            computerFactory = computerFactoryOptional.get();
            Mouse mouse = computerFactory.createMouse();
            Keyboard keyboard = computerFactory.createKeyboard();

            Application application = new Application(keyboard, mouse);
            application.render();
        }

        osType = "mac";
        Optional<ComputerFactory> macFactoryOptional = FactoryFinder.getComputer(osType);
        if (macFactoryOptional.isPresent()){
            computerFactory = macFactoryOptional.get();
            Mouse mouse = computerFactory.createMouse();
            Keyboard keyboard = computerFactory.createKeyboard();

            Application application = new Application(keyboard, mouse);
            application.render();
        }
    }
}
