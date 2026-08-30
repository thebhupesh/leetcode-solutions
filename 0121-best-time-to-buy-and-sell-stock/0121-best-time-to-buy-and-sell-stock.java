class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;

        for(int sell=1; sell<prices.length; sell++) {
            if(prices[sell]<prices[buy]) buy = sell;
            else profit = Math.max(prices[sell]-prices[buy],profit);
        }

        return profit;
    }
}