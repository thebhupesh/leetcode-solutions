class Solution {
    public int jump(int[] nums) {
        int end = nums.length-1;

        if(end == 0) return 0;

        int res = 0;
        int maxJump = 0;
        int frameEnd = 0;

        for(int i=0;; i++) {
            int jump = i+nums[i];

            if(jump > maxJump) {
                if(jump >= end) {
                    res++;
                    break;
                }
                maxJump = jump;
            }

            if(frameEnd == i) {
                res++;
                frameEnd = maxJump;
            }
        }

        return res;
    }
}