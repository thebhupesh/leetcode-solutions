class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        int res = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i,j,0});
                if(grid[i][j] == 1) fresh++;
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            res = Math.max(res,curr[2]);

            for(int[] dir : dirs) {
                int i = curr[0]+dir[0];
                int j = curr[1]+dir[1];

                if(i>=0 && j>=0 && i<m && j<n && grid[i][j] == 1) {
                    fresh--;
                    grid[i][j] = 2;
                    queue.offer(new int[]{i,j,curr[2]+1});
                }
            }
        }

        if(fresh != 0) return -1;

        return res;
    }
}