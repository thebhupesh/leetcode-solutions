class Solution {
    public void traverse(char[][] grid, int[] curr, int m, int n) {
        int[][] dirs = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(curr);

        while(!stack.isEmpty()) {
            curr = stack.pop();

            for(int[] dir : dirs) {
                int i = curr[0]+dir[0];
                int j = curr[1]+dir[1];

                if(i>=0 && i<m && j>=0 && j<n && grid[i][j] == '1') {
                    grid[i][j] = '0';
                    stack.push(new int[]{i,j});
                }
            }
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