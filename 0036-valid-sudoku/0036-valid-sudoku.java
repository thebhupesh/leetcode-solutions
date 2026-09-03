class Solution {
    private boolean checkGrid(char[][] grid, int m, int n) {
        boolean[] exists = new boolean[9];
        
        for(int i=m; i<m+3; i++) {
            for(int j=n; j<n+3; j++) {
                if(grid[i][j] == '.') continue;
                
                if(exists[grid[i][j]-'1']) return false;
                exists[grid[i][j]-'1'] = true;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            boolean[] exists = new boolean[9];
            for(int j=0; j<9; j++) {
                if(i%3==0 && j%3==0 && !checkGrid(board,i,j)) return false;
                if(board[i][j] == '.') continue;

                if(exists[board[i][j]-'1']) return false;
                exists[board[i][j]-'1'] = true;
            }

            exists = new boolean[9];
            for(int j=0; j<9; j++) {
                if(board[j][i] == '.') continue;

                if(exists[board[j][i]-'1']) return false;
                exists[board[j][i]-'1'] = true;
            }
        }

        return true;
    }
}