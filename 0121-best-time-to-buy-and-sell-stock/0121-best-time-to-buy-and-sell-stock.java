class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        
        int buy = prices[0];
        int sell = prices[1];
        int profit = Math.max(0, sell-buy);

        for(int i=1; i<prices.length; i++) {
            if(i<prices.length-1 && prices[i] < buy) {
                buy = prices[i];
                sell = prices[i+1];
            } else if(prices[i] > sell) {
                sell = prices[i];
            }

            profit = Math.max(profit, sell-buy);
        }

        return profit;
    }
}