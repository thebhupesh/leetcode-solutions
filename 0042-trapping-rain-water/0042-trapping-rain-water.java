class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length-1];

        int left = 1;
        int right = height.length-2;

        int res = 0;

        while(left <= right) {
            if(leftMax < rightMax) {
                if(leftMax > height[left]) res += leftMax-height[left];
                else leftMax = height[left];
                left++;
            } else {
                if(rightMax > height[right]) res += rightMax-height[right];
                else rightMax = height[right];
                right--;
            }
           
        }

        return res;
    }
}