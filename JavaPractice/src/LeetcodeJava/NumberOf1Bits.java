package LeetcodeJava;


public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int output = 0;
        while(n!=0){
            n -= n&-n;
            output++;
        }
        return output;
    }
    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();
        int n=11;
        System.out.println(obj.hammingWeight(n));
    }
}
