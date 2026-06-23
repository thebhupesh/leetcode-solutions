class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        
        if(len == 0) {
            return new int[][]{newInterval};
        }
        
        ArrayList<int[]> res = new ArrayList<>();
        
        for(int[] curr : intervals) {
            if(newInterval == null || newInterval[0] > curr[1]) {
                res.add(curr);
            } else if(curr[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(curr);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0],curr[0]);
                newInterval[1] = Math.max(newInterval[1],curr[1]);
            }
        }

        if(newInterval != null) {
            res.add(newInterval);
        }

        int[][] ans = new int[res.size()][];

        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}