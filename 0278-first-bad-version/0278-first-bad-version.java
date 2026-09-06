/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int min = 1;
        int max = n;

        while(min <= max) {
            int mid = min + (max-min)/2;

            boolean isBad = isBadVersion(mid);

            if(!isBad) min = mid+1;
            else if(isBadVersion(mid-1)) max = mid-1;
            else return mid;
        }

        return -1;
    }
}