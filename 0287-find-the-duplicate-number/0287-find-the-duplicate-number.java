class Solution {
    public int findDuplicate(int[] nums) {
        int[] counts = new int[100001];

        for(int num : nums) {
            if(counts[num] == 1) return num;

            counts[num]++;
        }

        return -1;
    }
}