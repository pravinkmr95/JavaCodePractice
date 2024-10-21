package LeetcodeJava;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2){
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i=1; i<n; i++){
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        for (int i=0; i<20; i++)
            System.out.print(obj.climbStairs(i) + " ");
        System.out.println();
    }
}
