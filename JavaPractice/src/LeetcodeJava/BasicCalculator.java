package LeetcodeJava;

import java.util.ArrayDeque;
import java.util.Deque;


public class BasicCalculator {
    public int calculate(String string) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result=0;
        int sign=1;
        int i=0;
        while (i < string.length()){
            char ch = string.charAt(i);
            if (Character.isDigit(ch)){
                int number = 0;
                while (i < string.length() && Character.isDigit(string.charAt(i))){
                    number = number*10 + (string.charAt(i) - '0');
                    i++;
                }
                result += number * sign;
                i--;
            } else if (ch == '+'){
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')'){
                sign = stack.pop();
                int number = stack.pop();
                result = number + sign*result;
            }
            i++;
        }
        return result;
    }

    public int basicCalculate(String s){// for practice
        int sign = 1;
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i<s.length()){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                int number = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    number = number*10 + (s.charAt(i) - '0');
                    i++;
                }
                // System.out.println(number);
                result += sign*number;
                i--;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                int oldSign = stack.pop();
                int oldNumber = stack.pop();
                result = oldNumber + result*oldSign;
            }
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        //tomorrow's implementations
        // Jump game II
        // Basic Calculator
        // SOLID Principle-> Strategy Design pattern
//        String s = "(1+(4+5+2)-3)+(6+8)";
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate("12345+100"));
        System.out.println(basicCalculator.calculate(" 1 + 1 "));
        System.out.println(basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));

        System.out.println("new");
        System.out.println(basicCalculator.basicCalculate("12345+100"));
        System.out.println(basicCalculator.basicCalculate(" 1 + 1 "));
        System.out.println(basicCalculator.basicCalculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
