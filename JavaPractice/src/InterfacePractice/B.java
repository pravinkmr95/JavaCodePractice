package InterfacePractice;

public interface B {
    int X=100;
    void getInfo();

    static void main(String[] args) {
        privateStatic();
    }

    default void print(){
        privateVoid();
        privateStatic();
    }

    private static void privateStatic(){
        System.out.println("in private static");
    }

    private void privateVoid(){
        System.out.println("in private");
    }
}
