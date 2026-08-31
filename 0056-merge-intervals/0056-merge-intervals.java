class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int[] curr = intervals[0];

        for(int[] interval : intervals) {
            if(interval[0] <= curr[1]) {
                curr[0] = Math.min(curr[0],interval[0]);
                curr[1] = Math.max(curr[1],interval[1]);
            } else {
                res.add(curr);
                curr = interval;
            }
        }

        res.add(curr);

        return res.toArray(new int[0][0]);
    }
}