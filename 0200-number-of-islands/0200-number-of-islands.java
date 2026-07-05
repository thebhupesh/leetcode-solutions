class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Pair<Integer,Integer>> lands = new HashSet<>();
        Stack<Pair<Integer,Integer>> s = new Stack<>();
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    lands.add(new Pair<>(i,j));
                }
            }
        }

        while(!lands.isEmpty()) {
            s.push(lands.iterator().next());
            while(!s.isEmpty()) {
                Pair<Integer,Integer> curr = s.pop();
                lands.remove(curr);
                int i = curr.getKey(), j = curr.getValue();
                visited[i][j] = true;

                if(i>0 && grid[i-1][j] == '1' && !visited[i-1][j]) s.push(new Pair<>(i-1,j));
                if(j>0 && grid[i][j-1] == '1' && !visited[i][j-1]) s.push(new Pair<>(i,j-1));
                if(i+1<m && grid[i+1][j] == '1' && !visited[i+1][j]) s.push(new Pair<>(i+1,j));
                if(j+1<n && grid[i][j+1] == '1' && !visited[i][j+1]) s.push(new Pair<>(i,j+1));
            }
            result++;
        }

        return result;
    }
}