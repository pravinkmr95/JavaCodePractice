package Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void foo() throws CustomException, FileNotFoundException {
        //throw new CustomException("Error message");
    }
    public static void main(String[] args) throws CustomException{
        try{
            foo();
            System.out.println(Integer.toBinaryString(30));
            System.out.println(1<<3);
            System.out.println(2.0/0);
            System.exit(0);


        } catch (FileNotFoundException e){
            System.out.println("FNF");
        }
//        catch (IOException e){
//            System.out.println("OtherIO");
//        }
        catch (CustomException e){
            System.out.println("Caught custom exception");
            //throw e;
        } finally {
            System.out.println("Inside finally block");
        }
    }
}
