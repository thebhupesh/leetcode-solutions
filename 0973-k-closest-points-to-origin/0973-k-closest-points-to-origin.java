class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> c = (a, b) -> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>(points.length, c);

        for(int[] point : points) {
            q.add(point);
        }

        int[][] res = new int[k][2];

        while(k>0) {
            res[--k] = q.poll();
        }

        return res;
    }
}