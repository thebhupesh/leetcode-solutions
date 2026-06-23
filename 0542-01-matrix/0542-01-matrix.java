class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] result = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            if(curr[0] != 0 && mat[curr[0]-1][curr[1]] == 1 && result[curr[0]-1][curr[1]] == 0) {
                result[curr[0]-1][curr[1]] = result[curr[0]][curr[1]]+1;
                q.add(new int[]{curr[0]-1,curr[1]});
            }
            if(curr[0]+1 != m && mat[curr[0]+1][curr[1]] == 1 && result[curr[0]+1][curr[1]] == 0) {
                result[curr[0]+1][curr[1]] = result[curr[0]][curr[1]]+1;;
                q.add(new int[]{curr[0]+1,curr[1]});
            }
            if(curr[1] != 0 && mat[curr[0]][curr[1]-1] == 1 && result[curr[0]][curr[1]-1] == 0) {
                result[curr[0]][curr[1]-1] = result[curr[0]][curr[1]]+1;;
                q.add(new int[]{curr[0],curr[1]-1});
            }
            if(curr[1]+1 != n && mat[curr[0]][curr[1]+1] == 1 && result[curr[0]][curr[1]+1] == 0) {
                result[curr[0]][curr[1]+1] = result[curr[0]][curr[1]]+1;;
                q.add(new int[]{curr[0],curr[1]+1});
            }
        }

        return result;
    }
}