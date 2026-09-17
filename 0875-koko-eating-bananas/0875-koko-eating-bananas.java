class Solution {
    private int eat(int[] piles, int speed) {
        int val = 0;

        for(int pile : piles) val += Math.ceil((double)pile/speed);

        return val;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;

        for(int pile : piles) max = Math.max(max,pile);

        int res = 0;

        while(min <= max) {
            int mid = min + (max-min)/2;

            if(eat(piles,mid) <= h) {
                max = mid-1;
                res = mid;
            }
            else min = mid+1;
        }

        return res;
    }
}