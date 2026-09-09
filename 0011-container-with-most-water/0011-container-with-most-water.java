class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length-1;

        int res = 0;

        while(p1 < p2) {
            int low = Math.min(height[p1],height[p2]);
            res = Math.max(res,(p2-p1)*low);

            if(height[p1] <= height[p2]) p1++;
            else p2--;

            while(p1<p2 && height[p1] <= low) p1++;
            while(p1<p2 && height[p2] <= low) p2--;
        }

        return res;
    }
}