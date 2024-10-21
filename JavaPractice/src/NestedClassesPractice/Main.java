package NestedClassesPractice;

public class Main {

    public static void main(String[] args) {
        Anonymous obj = new Anonymous(10) {
            @Override
            public void print() {
                System.out.println("Prints " + this.member);
            }
        };
        obj.print();

        StaticNested.Nested obj1 = new StaticNested.Nested();
        obj1.print();
    }
}
