package LeetcodeJava;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int a=1; a<amount+1; a++){
            for (int c: coins){
                if ((a-c) >= 0){
                    dp[a] = Math.min(dp[a], 1+dp[a-c]);
                }
            }
        }
        return dp[amount] != (amount+1) ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(obj.coinChange(coins, amount));
    }
}
