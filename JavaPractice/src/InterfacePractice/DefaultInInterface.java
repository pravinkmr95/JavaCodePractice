package InterfacePractice;

public interface DefaultInInterface {
    default int getValue(){
        return 10;
    }

    static void print(){
        System.out.println("Static method in interface");
    }

    int getData();
}
