package LLDPractice.DependencyInversion;

public class main {
    public static void main(String[] args) {
        // class should be dependent on interface rather than concrete classes
//        KeyBoard keyBoard = new KeyBoard("wired");
//        Mouse mouse = new Mouse("Wired");
//        Computer computer = new Computer(mouse, keyBoard);

        KeyBoardInterface keyBoard1 = new WiredKeyBoard();
        MouseInterface mouse1 = new WiredMouse();
        Computer computer1 = new Computer(mouse1, keyBoard1);

        computer1.setMouse(new BluetoothMouse());
    }
}
