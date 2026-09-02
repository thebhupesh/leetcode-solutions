class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean merged = false;

        for(int[] interval : intervals) {
            if(newInterval[1] < interval[0]) {
                if(!merged) {
                    res.add(newInterval);
                    merged = true;
                }
                res.add(interval);
            } else if(newInterval[0] <= interval[1]) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            } else res.add(interval);
        }
        
        if(!merged) res.add(newInterval);

        return res.toArray(new int[0][0]);
    }
}