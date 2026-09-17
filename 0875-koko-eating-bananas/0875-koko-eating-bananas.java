class Solution {
    private boolean eatable(int[] piles, double speed, int hour) {
        int val = 0;

        for(int i=piles.length-1; i>=0; i--) {
            val += (piles[i]+speed-1)/speed;

            if(val > hour) return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;

        for(int pile : piles) max = Math.max(max,pile);

        int res = 0;

        while(min <= max) {
            int mid = min + (max-min)/2;

            if(eatable(piles,mid,h)) {
                max = mid-1;
                res = mid;
            }
            else min = mid+1;
        }

        return res;
    }
}