class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = -1;
        int end = 0;
        Deque<Integer> zeros = new ArrayDeque<>();
        int res = 0;

        while(end+1 <= nums.length) {
            if(nums[end] == 1 && start == -1) start = end;
            else if(nums[end] == 0 && k != 0) {
                if(zeros.size() == k) start = zeros.poll()+1;
                else if(start == -1) start = end;
                zeros.offer(end);
            } else if(nums[end] == 0) start = -1;

            if(start != -1) res = Math.max(res, end-start+1);

            end++;
        }

        return res;
    }
}