class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        int maxTime = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            if(curr[0] > 0 && grid[curr[0]-1][curr[1]] == 1) {
                if(visited[curr[0]-1][curr[1]] > visited[curr[0]][curr[1]] + 1 || visited[curr[0]-1][curr[1]] == 0) {
                    visited[curr[0]-1][curr[1]] = visited[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{curr[0]-1,curr[1]});
                }
            }
            if(curr[1] > 0 && grid[curr[0]][curr[1]-1] == 1) {
                if(visited[curr[0]][curr[1]-1] > visited[curr[0]][curr[1]] + 1 || visited[curr[0]][curr[1]-1] == 0) {
                    visited[curr[0]][curr[1]-1] = visited[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{curr[0],curr[1]-1});
                }
            }
            if(curr[0]+1 < m && grid[curr[0]+1][curr[1]] == 1) {
                if(visited[curr[0]+1][curr[1]] > visited[curr[0]][curr[1]] + 1 || visited[curr[0]+1][curr[1]] == 0) {
                    visited[curr[0]+1][curr[1]] = visited[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{curr[0]+1,curr[1]});
                }
            }
            if(curr[1]+1 < n && grid[curr[0]][curr[1]+1] == 1) {
                if(visited[curr[0]][curr[1]+1] > visited[curr[0]][curr[1]] + 1 || visited[curr[0]][curr[1]+1] == 0) {
                    visited[curr[0]][curr[1]+1] = visited[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{curr[0],curr[1]+1});
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && visited[i][j] > 0) {
                    maxTime = Math.max(maxTime, visited[i][j]);
                } else if(grid[i][j] == 1 && visited[i][j] == 0) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}