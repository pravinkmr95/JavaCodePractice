package LeetcodeJava;

public class BestTimeToBuySellStock2 {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] > prices[i-1]){
                maxProfit += (prices[i] - prices[i-1]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        BestTimeToBuySellStock2 obj = new BestTimeToBuySellStock2();
        System.out.println(obj.maxProfit(arr));
    }
}
