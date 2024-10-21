package InterfacePractice;

public class AbstractMain extends AbstractClass {
    @Override
    public void test() {

    }

    public static void main(String[] args) {
        AbstractClass obj = new AbstractClass() {
            @Override
            public void test() {
                System.out.println("Override");
            }
        };
    }
}
