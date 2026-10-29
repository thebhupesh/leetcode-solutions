class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int res = 0;

        for(int i=0; i<=heights.length; i++) {
            if(i<heights.length && (stack.isEmpty() || stack.peek()[0] <= heights[i])) {
                stack.push(new int[]{heights[i],i});
            } else {
                int[] curr = new int[2];
                while(!stack.isEmpty() && (i == heights.length || stack.peek()[0] > heights[i])) {
                    curr = stack.pop();

                    res = Math.max(res,curr[0]*(i-curr[1]));
                }

                if(i < heights.length) stack.push(new int[]{heights[i],curr[1]});
            }
        }

        return res;
    }
}