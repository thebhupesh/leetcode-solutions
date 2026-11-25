class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int pos = 0;

        for(int i=1; i<asteroids.length; i++) {
            boolean stop = false;
            int val = asteroids[i];
            while(!stop) {
                if(pos == -1 || asteroids[pos] < 0 || (val > 0 && asteroids[pos] > 0)) {
                    pos++;
                    asteroids[pos] = val;
                    stop = true;
                } else {
                    if(Math.abs(val) > Math.abs(asteroids[pos])) {
                        pos--;
                    } else if(Math.abs(val) == Math.abs(asteroids[pos])) {
                        stop = true;
                        pos--;
                    }
                    else stop = true;
                }
            }
        }
        
        return Arrays.copyOfRange(asteroids,0,pos+1);
    }
}