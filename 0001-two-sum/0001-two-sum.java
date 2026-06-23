class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();

        int[] result = new int[2];

        for(int i=0; i<nums.length; i++) {
            if(!mp.containsKey(nums[i])) {
                mp.put(target-nums[i], i);
            } else {
                result[0] = mp.get(nums[i]);
                result[1] = i;
            }
        }

        return result;
    }
}