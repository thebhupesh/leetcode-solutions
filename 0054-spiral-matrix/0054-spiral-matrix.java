class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int count = m*n;
        int i = 0;
        int j = 0;
        
        char dir = 'R';
        int R_limit = n-1;
        int L_limit = 0;
        int U_limit = 1;
        int D_limit = m-1;

        while(count != 0) {
            while(true) {
                res.add(matrix[i][j]);
                count--;

                if(dir == 'R') {
                    if(j == R_limit) {
                        i++;
                        dir = 'D';
                        R_limit--;
                        break;
                    }
                    j++;
                }
                else if(dir == 'D') {
                    if(i == D_limit) {
                        j--;
                        dir = 'L';
                        D_limit--;   
                        break;
                    }
                    i++;
                }
                else if(dir == 'L') {
                    if(j == L_limit) {
                        i--;
                        dir = 'U';
                        L_limit++;
                        break;
                    }
                    j--;
                }
                else if(dir == 'U') {
                    if(i == U_limit) {
                        j++;
                        dir = 'R';
                        U_limit++;
                        break;
                    }
                    i--;
                }
            }
        }

        return res;
    }
}