class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddCount = 0;
        int evenCount = 0;

        int min = Integer.MAX_VALUE;

        for(int n : nums1) {
            min = Math.min(n,min);
            if(n%2 == 0) evenCount++;
            else oddCount++;
        }

        if(min%2 != 0 || oddCount == 0) return true;
        else return false;
    }
}