class Solution {
    private static final int[][] dirs = {
            {1,0},{0,1},{-1,0},{0,-1}
        };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] reachPacific = new boolean[m][n];
        boolean[][] reachAtlantic = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<m; i++) {
            q.offer(new int[]{i,0});
            reachPacific[i][0] = true;
        }

        for(int i=1; i<n; i++) {
            q.offer(new int[]{0,i});
            reachPacific[0][i] = true;
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int[] dir : dirs) {
                int i = curr[0]+dir[0];
                int j = curr[1]+dir[1];

                if(i>=0 && j>=0 && i<m && j<n && !reachPacific[i][j] && heights[i][j] >= heights[curr[0]][curr[1]]) {
                    reachPacific[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            q.offer(new int[]{i,n-1});
            reachAtlantic[i][n-1] = true;
        }

        for(int i=0; i<n-1; i++) {
            q.offer(new int[]{m-1,i});
            reachAtlantic[m-1][i] = true;
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            if(reachPacific[curr[0]][curr[1]]) res.add(List.of(curr[0],curr[1]));

            for(int[] dir : dirs) {
                int i = curr[0]+dir[0];
                int j = curr[1]+dir[1];

                if(i>=0 && j>=0 && i<m && j<n && !reachAtlantic[i][j] && heights[i][j] >= heights[curr[0]][curr[1]]) {
                    reachAtlantic[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        return res;
    }
}