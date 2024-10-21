package NestedClassesPractice;

public class InnerClass {
    public static int a;
    public int b;
    class Nested{
        public void print(){
            System.out.println("Inside nested class " + a + " " + b);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        InnerClass.Nested innerObj = innerClass.new Nested();
        innerObj.print();
    }
}
