package NestedClassesPractice;

public class StaticNested {
    public static int a;
    public int b;
    static class Nested{
        public void print(){
            System.out.println("Inside nested class " + a);
        }
    }

    public static void main(String[] args) {
        StaticNested.Nested obj = new StaticNested.Nested();
        obj.print();
    }
}
