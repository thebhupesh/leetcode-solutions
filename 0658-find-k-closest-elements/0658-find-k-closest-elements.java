class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0;
        int right = len-1;

        while(left < right) {
            int mid = left + (right-left)/2;

            if(arr[mid] < x) left = mid+1;
            else right = mid;
        }

        right = left;
        left--;

        while(k > 0) {
            if(left >= 0 && right < len) {
                int lVal = Math.abs(arr[left]-x);
                int rVal = Math.abs(arr[right]-x);

                if(lVal < rVal) left--;
                else if(lVal > rVal) right++;
                else if(arr[left] < arr[right]) left--;
                else right++;
            } else if(left >= 0) left--;
            else right++;

            k--;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=left+1; i<right; i++) res.add(arr[i]);

        return res;
    }
}