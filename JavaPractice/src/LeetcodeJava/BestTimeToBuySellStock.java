package LeetcodeJava;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int size = prices.length;
        int maxFromEnd = prices[size-1];
        for (int i=size-2; i>=0; i--){
            if (prices[i] < maxFromEnd){
                maxProfit = Math.max(maxProfit, (maxFromEnd - prices[i]));
            } else {
                maxFromEnd = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
        System.out.println(obj.maxProfit(arr));
    }
}
