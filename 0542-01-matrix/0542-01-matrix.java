class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dirs = {
            {-1,0},
            {0,-1},
            {1,0},
            {0,1}
        };
        
        Deque<int[]> q = new ArrayDeque<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) q.offerLast(new int[]{i,j});
                else mat[i][j] = -1;
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.pollFirst();
            int i = curr[0], j = curr[1];

            for(int[] dir : dirs) {
                if((i+dir[0])>=0 && (i+dir[0])<m && (j+dir[1])>=0 && (j+dir[1])<n) {
                    if(mat[i+dir[0]][j+dir[1]] != -1) mat[i][j] = Math.min(mat[i][j],mat[i+dir[0]][j+dir[1]]+1);
                    else {
                        q.offerLast(new int[]{i+dir[0],j+dir[1]});
                        mat[i+dir[0]][j+dir[1]] = Integer.MAX_VALUE-1;
                    }
                }
            }
        }

        return mat;
    }
}