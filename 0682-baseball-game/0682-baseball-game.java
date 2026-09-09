class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> s = new ArrayDeque<>();
        int prev = 0;
        int res = 0;

        for(String op : operations) {
            if(op.equals("+")) {
                int temp = s.peekFirst();
                s.offerFirst(prev+temp);
                prev = temp;
            } else if(op.equals("D")) {
                int temp = s.peekFirst();
                s.offerFirst(temp*2);
                prev = temp;
            } else if(op.equals("C")) {
                s.pollFirst();
                if(s.size() > 1) {
                    int temp = s.pollFirst();
                    prev = s.peekFirst();
                    s.offerFirst(temp);
                }
            } else {
                if(s.size() > 0) prev = s.peekFirst();
                s.offerFirst(Integer.parseInt(op));
            }
        }

        while(!s.isEmpty()) res += s.pollFirst();

        return res;
    }
}