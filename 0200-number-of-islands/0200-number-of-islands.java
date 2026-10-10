class Solution {
    public void traverse(char[][] grid, int[] curr, int m, int n) {
        if(curr[0]<0 || curr[0]==m || curr[1]<0 || curr[1]==n || grid[curr[0]][curr[1]] == '0') return;

        int[][] dirs = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };

        grid[curr[0]][curr[1]] = '0';

        for(int[] dir : dirs) {
            int i = curr[0]+dir[0];
            int j = curr[1]+dir[1];

            traverse(grid, new int[]{i,j}, m, n);
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    traverse(grid, new int[]{i,j}, m, n);
                }
            }
        }

        return res;
    }
}