class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int res = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[buy] < prices[i]) res += (prices[i]-prices[buy]);
            buy = i;
        }

        return res;
    }
}