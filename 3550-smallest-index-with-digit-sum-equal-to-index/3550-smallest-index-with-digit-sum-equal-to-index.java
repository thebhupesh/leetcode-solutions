class Solution {
    private boolean check(int num, int i) {        
        while(num != 0) {
            i -= num%10;
            num /= 10;
        }
        
        return i == 0;
    }

    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++) if(check(nums[i],i)) return i;
        return -1;
    }
}