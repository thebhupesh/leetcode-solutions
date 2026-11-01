class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
        int res = 0;

        for(int i=0; i<len; i++) {
            if(citations[i] <= len-i) {
                res = citations[i];
            } else res = Math.max(res,len-i);
        }

        return res;
    }
}