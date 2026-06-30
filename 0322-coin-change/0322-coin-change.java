class Solution {
    Map<Long,Integer> dp = new HashMap<>();
    private int findChange(int[] coins, int amt, long curr) {
        if(curr == amt) {
            return 0;
        } else if(curr > amt) {
            return -1;
        }

        if(dp.containsKey(curr)) {
            return dp.get(curr);
        }

        int val = Integer.MAX_VALUE;

        for(int i=coins.length-1; i>=0; i--) {
            int temp = findChange(coins, amt, curr+coins[i]);

            if(temp != -1) {
                val = Math.min(temp+1,val);
            }
        }

        if(val == Integer.MAX_VALUE) val = -1;

        dp.put(curr, val);
        return val;
    }

    public int coinChange(int[] coins, int amount) {
        return findChange(coins, amount, 0);
    }
}