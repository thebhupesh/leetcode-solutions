class Solution {
    private boolean eatable(int[] piles, double speed, int hour) {
        int val = 0;

        for(int i=piles.length-1; i>=0; i--) {
            val += (int)Math.ceil(piles[i]/speed);

            if(val > hour) return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int min = 1;
        int max = piles[piles.length-1];
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