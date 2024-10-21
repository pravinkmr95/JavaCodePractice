package LeetcodeJava;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                if (ch == ')'){
                    char last = stack.pop();
                    if (last != '('){
                        return false;
                    }
                } else if (ch == '}') {
                    char last = stack.pop();
                    if (last != '{'){
                        return false;
                    }
                } else if (ch == ']'){
                    char last = stack.pop();
                    if (last != '['){
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));

        System.out.println(validParentheses.isValid("()[]{}"));

        System.out.println(validParentheses.isValid("(]"));

        System.out.println(validParentheses.isValid("([])"));

    }
}
