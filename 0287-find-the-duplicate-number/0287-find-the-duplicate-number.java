class Solution {
    public int findDuplicate(int[] nums) {
        int[] counts = new int[100000];

        for(int num : nums) {
            if(counts[num-1] == 1) return num;

            counts[num-1]++;
        }

        return -1;
    }
}