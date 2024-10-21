package Exceptions;

import java.io.FileNotFoundException;

public class ExceptionTest {
    public static void main(String[] args) {
        Object x = 10;
        //System.out.println((String) x); // ClassCastException

        //System.out.println(5/0); // ArithmeticException

        int[] arr = new int[5];
        // System.out.println(arr[5]); // ArrayIndexOutOfBoundsException

        String s = "string";
        // System.out.println(s.charAt(7)); // StringIndexOutOfBoundsException

        s = null;
        //System.out.println(s.charAt(0)); // NullPointerException

        //System.out.println(Integer.parseInt("abcd")); // NumberFormatException
        try{
            foo();
            //return;
        } catch (ClassNotFoundException exception){
            System.out.println("Exception occurred");
        } catch (Exception ex){
            System.out.println("Parent exception");
        } finally {
            System.out.println("In finally block");
        }
        multipleCatch();
    }

    public static void foo() throws ClassNotFoundException{
        return;
        //throw new ClassNotFoundException();
    }

    public static void foo1() throws ClassNotFoundException, FileNotFoundException{
        //return;
        throw new ClassNotFoundException();
        //throw new NullPointerException();
    }

    public static void multipleCatch(){
        System.out.println("multi catch called");
        try{
            foo1();
        } catch (ClassNotFoundException | FileNotFoundException ex){
            System.out.println("Multiple catch single line");
        }
    }
}
