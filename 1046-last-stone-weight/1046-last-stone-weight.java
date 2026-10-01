class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) q.add(stone);

        while(q.size() > 1) {
            int val = q.poll() - q.poll();

            if(val > 0) q.offer(val);
        }

        return (q.size() > 0) ? q.element() : 0;
    }
}