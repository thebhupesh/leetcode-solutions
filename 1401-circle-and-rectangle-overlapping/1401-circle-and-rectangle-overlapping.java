class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // (x-xCenter)^2+(y-yCenter)^2=r^2
        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
                int x = i-xCenter;
                int y = j-yCenter;

                if((x*x)+(y*y)-(radius*radius) <= 0) return true;
            }
        }

        return false;
    }
}