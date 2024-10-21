package LeetcodeJava;

public class LongestCommonSubsequence {
    public int longestCommonSubsequenceRecUtil(String text1, String text2, int m, int n){
        if (m==0 || n==0){
            return 0;
        }
        if (text1.charAt(m-1) == text2.charAt(n-1)){
            return 1 + longestCommonSubsequenceRecUtil(text1, text2, m-1, n-1);
        } else {
            return Math.max(longestCommonSubsequenceRecUtil(text1, text2, m, n-1),
                    longestCommonSubsequenceRecUtil(text1, text2, m-1, n));
        }
    }
    public int longestCommonSubsequenceRec(String text1, String text2){
        return longestCommonSubsequenceRecUtil(text1, text2, text1.length(), text2.length());
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        // set 0 in first row and column. Java sets by default
        for (int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));

        System.out.println(longestCommonSubsequence.longestCommonSubsequenceRec(text1, text2));
    }
}
