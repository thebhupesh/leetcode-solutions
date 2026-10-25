class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = 0;
        int ptr2 = 0;

        int[] res = new int[m+n];
        int ptr = 0;

        while(ptr < m+n) {
            if(ptr1 < m && ptr2 < n) {
                if(nums1[ptr1] <= nums2[ptr2]) {
                    res[ptr] = nums1[ptr1];
                    ptr1++;
                } else {
                    res[ptr] = nums2[ptr2];
                    ptr2++;
                }
            } else if(ptr1 < m) {
                res[ptr] = nums1[ptr1];
                ptr1++;
            } else {
                res[ptr] = nums2[ptr2];
                ptr2++;
            }

            ptr++;
        }

        for(int i=0; i<m+n; i++) nums1[i] = res[i];
    }
}