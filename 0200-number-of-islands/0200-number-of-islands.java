class Solution {
    int m,n;
    
    private void check(char[][] grid, int i, int j) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{i,j});
        grid[i][j] = 'L';

        while(!s.isEmpty()) {
            int[] curr = s.pop();

            if(curr[0]>0 && grid[curr[0]-1][curr[1]] == '1') {
                s.push(new int[]{curr[0]-1,curr[1]});
                grid[curr[0]-1][curr[1]] = 'L';
            }
            if(curr[1]>0 && grid[curr[0]][curr[1]-1] == '1') {
                s.push(new int[]{curr[0],curr[1]-1});
                grid[curr[0]][curr[1]-1] = 'L';
            }
            if(curr[0]+1<m && grid[curr[0]+1][curr[1]] == '1') {
                s.push(new int[]{curr[0]+1,curr[1]});
                grid[curr[0]+1][curr[1]] = 'L';
            }
            if(curr[1]+1<n && grid[curr[0]][curr[1]+1] == '1') {
                s.push(new int[]{curr[0],curr[1]+1});
                grid[curr[0]][curr[1]+1] = 'L';
            }
        }
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    check(grid,i,j);
                    result++;
                }
            }
        }

        return result;
    }
}