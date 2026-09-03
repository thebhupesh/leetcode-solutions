class Solution {
    public long distance(int[] point) {
        return point[0]*point[0]+point[1]*point[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> closePoints = new PriorityQueue<>(k,(curr,top)->(int)(distance(top) - distance(curr)));

        for(int[] point : points) {
            if(closePoints.size() < k) {
                closePoints.add(point);
                continue;
            }

            if(distance(closePoints.peek()) < distance(point)) continue;
            
            closePoints.poll();
            closePoints.add(point);
        }

        return closePoints.toArray(new int[k][2]);
    }
}