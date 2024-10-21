package LeetcodeJava;

public class ReverseBits {
    public int reverseBits(int n) {
        int output = 0;
        for (int i=0; i<32; i++){
            if ((n & 1) != 0){
                output = output | 1<<(31-i);
            }
            //System.out.println(n);
            n = n >> 1;
        }
        return output;
    }

    public int reverseBits1(int n) {
        int output = 0;
        for (int i=0; i<32; i++){
            int digit = (n >> i) & 1;
            if (digit != 0){
                output = output | (1<<(31-i));
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int n=10;
        ReverseBits obj = new ReverseBits();
        System.out.println(obj.reverseBits(n));
    }
}
