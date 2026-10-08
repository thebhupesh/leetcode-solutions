class Solution {

    private boolean check(char[][] board, String word, int pos, int i, int j, boolean[][] visited) {        
        boolean res = false;
        
        if(board[i][j] == word.charAt(pos)) {
            visited[i][j] = true;
            
            if(pos+1 == word.length()) return true;

            if(i+1 < board.length && !visited[i+1][j]) res = check(board, word, pos+1, i+1, j, visited);
            if(!res && i > 0 && !visited[i-1][j]) res = check(board, word, pos+1, i-1, j, visited);
            if(!res && j+1 < board[0].length && !visited[i][j+1]) res = check(board, word, pos+1, i, j+1, visited);
            if(!res && j > 0 && !visited[i][j-1]) res = check(board, word, pos+1, i, j-1, visited);
        }

        visited[i][j] = false;
        
        return res;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && check(board, word, 0, i, j, new boolean[board.length][board[0].length])) return true;
            }
        }

        return false;
    }
}


// ABCE
// SFES
// ADEE