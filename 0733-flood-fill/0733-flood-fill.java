class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int clr = image[sr][sc];
        if(clr == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr,sc});

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            sr = temp[0];
            sc = temp[1];

            if(sr<0 || sr>=m || sc<0 || sc>=n || image[sr][sc] != clr) {
                continue;
            }

            image[sr][sc] = color;
            
            q.add(new int[]{sr-1,sc});
            q.add(new int[]{sr,sc-1});
            q.add(new int[]{sr+1,sc});
            q.add(new int[]{sr,sc+1});
        }

        return image;
    }
}