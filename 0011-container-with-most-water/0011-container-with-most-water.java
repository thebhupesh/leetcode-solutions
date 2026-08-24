class Solution {
    public int maxArea(int[] height) {
        int ptr1 = 0;
        int ptr2 = height.length-1;
        int maxAr = 0;

        while(ptr1<ptr2) {
            maxAr = Math.max(maxAr, Math.min(height[ptr1],height[ptr2])*(ptr2-ptr1));

            if(height[ptr1] <= height[ptr2]) ptr1++;
            else ptr2--;
        }

        return maxAr;
    }
}