class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[] distance = new int[len];
        boolean[] mst = new boolean[len];
        int remaining = len;

        int res = 0;
        int currPoint = 0;
        int currDist = 0;

        Arrays.fill(distance, Integer.MAX_VALUE);

        while(remaining > 0) {
            mst[currPoint] = true;
            res += currDist;
            remaining--;
            
            int tempPoint = currPoint;
            currDist = Integer.MAX_VALUE;

            for(int i=0; i<len; i++) {
                if(!mst[i]) {
                    distance[i] = Math.min(distance[i], Math.abs(points[i][0]-points[tempPoint][0]) + Math.abs(points[i][1]-points[tempPoint][1]));

                    if(distance[i] < currDist) {
                        currDist = distance[i];
                        currPoint = i;
                    }
                }
            }
        }
        
        return res;
    }
}