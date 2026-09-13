class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m-1;

        while(low <= high) {
            int pos = low + (high-low)/2;

            if(matrix[pos][n-1] >= target && matrix[pos][0] <= target) {
                low = 0;
                high = n-1;
                while(low <= high) {
                    int mid = low + (high-low)/2;

                    if(matrix[pos][mid] == target) return true;
                    else if(matrix[pos][mid] < target) low = mid+1;
                    else high = mid-1;
                }
                break;
            } else if(matrix[pos][n-1] >= target) high = pos-1;
            else low = pos+1;
        }

        return false;
    }
}