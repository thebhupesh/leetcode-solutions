class Solution {
    int[] wts;
    Random r;

    public Solution(int[] w) {
        r = new Random();
        wts = new int[w.length];
        wts[0] = w[0];

        for(int i=1; i<w.length; i++) {
            wts[i] = w[i]+wts[i-1];
        }
    }
    
    public int pickIndex() {
        int len = wts.length;
        int target = r.nextInt(wts[len-1]);

        int min = 0;
        int max = len-1;

        while(min < max) {
            int mid = min + (max-min)/2;

            if(wts[mid] <= target) min = mid+1;
            else max = mid;
        }

        return min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */