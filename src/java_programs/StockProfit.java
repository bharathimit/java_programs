package java_programs;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class StockProfit {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        
        int min  = prices[0];
        int max  = prices[0];
        int diff = 0;
        
        /*
         * The core is once u find a min value, the max value before that 
         * is not valuable anymore.
         */
        for(int i=1; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
                max = -1; // Prices cannot be negative. If not we can use Integer.MIN
            }else if(max < prices[i]){
                max = prices[i];
                if(diff < (max-min)){
                    diff = max-min;
                }
            }
        }
        return diff;
    }
}
