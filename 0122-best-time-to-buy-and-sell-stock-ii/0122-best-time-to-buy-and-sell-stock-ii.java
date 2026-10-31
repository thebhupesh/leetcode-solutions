class Solution {
    public int maxProfit(int[] prices) {
        int p1 = 0;
        int res = 0;

        for(int i=1; i<prices.length; i++) {
            if(prices[p1] < prices[i]) res += (prices[i]-prices[p1]);
            p1 = i;
        }

        return res;
    }
}