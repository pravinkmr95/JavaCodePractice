package LeetcodeJava;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        // dp[i] means number of ways to decode the substring s[0..i-1]
        dp[0] = 1; // There's one way to decode an empty string
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i=2; i<=n; i++){
            int number1 = Integer.parseInt(s.substring(i-1, i));
            if (number1 > 0 && number1 < 10){
                dp[i] += dp[i-1];
            }
            int number2 = Integer.parseInt(s.substring(i-2, i));
            if (number2 > 9 && number2 < 27){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "12";
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings(s));

        System.out.println(obj.numDecodings("226"));

        System.out.println(obj.numDecodings("06"));
    }
}
