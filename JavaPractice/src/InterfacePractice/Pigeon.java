package InterfacePractice;

public class Pigeon implements Bird{
    @Override
    public void fly() {
        System.out.println("Pigeon impl");
    }

    @Override
    public void foo() {

    }

    @Override
    public void getInfo() {

    }

    public static void main(String[] args) {
        Bird x = new Pigeon();
        x.print();
    }
}
