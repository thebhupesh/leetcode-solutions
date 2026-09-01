class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];
        int count = m*n;
        int i = 0;
        int j = 0;
        char dir = 'R';

        while(count != 0) {
            while(true) {
                res.add(matrix[i][j]);
                visited[i][j] = true;
                count--;

                if(dir == 'R') {
                    if(j == n-1 || visited[i][j+1]) break;
                    j++;
                }
                else if(dir == 'D') {
                    if(i == m-1 || visited[i+1][j]) break;
                    i++;
                }
                else if(dir == 'L') {
                    if(j == 0 || visited[i][j-1]) break;
                    j--;
                }
                else if(dir == 'U') {
                    if(i == 0 || visited[i-1][j]) break;
                    i--;
                }
            }

            if(dir == 'R') {
                i++;
                dir = 'D';
            }
            else if(dir == 'D') {
                j--;
                dir = 'L';
            }
            else if(dir == 'L') {
                i--;
                dir = 'U';
            }
            else if(dir == 'U') {
                j++;
                dir = 'R';
            }
        }

        return res;
    }
}