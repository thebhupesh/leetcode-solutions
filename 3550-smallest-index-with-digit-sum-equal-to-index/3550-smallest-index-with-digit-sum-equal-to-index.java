class Solution {
    private boolean check(String num, int i) {
        int sum = 0;
        for(char digit : num.toCharArray()) sum += (digit-'0');
        return sum == i;
    }

    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++) if(check(Integer.toString(nums[i]),i)) return i;
        return -1;
    }
}