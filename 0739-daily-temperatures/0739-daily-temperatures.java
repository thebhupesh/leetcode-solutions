class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> s = new ArrayDeque<>();

        for(int i=0; i<temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int idx = s.pop();
                res[idx] = i-idx;
            }

            s.push(i);
        }

        return res;
    }
}