package InterfacePractice;

public class FunctionalConcrete {
    public static void main(String[] args) {
        FunctionalInterfaceTest obj = () -> {
            System.out.println("Functional interface with lambda");
        };
        obj.foo();
    }


}
