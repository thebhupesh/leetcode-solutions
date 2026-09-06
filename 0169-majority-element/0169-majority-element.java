class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int maj = 0;

        for(int n : nums) {
            if(n != res) maj--;
            else maj++;

            if(maj < 0) {
                res = n;
                maj = 1;
            }
        }

        return res;
    }
}