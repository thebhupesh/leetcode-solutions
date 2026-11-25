class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int val = Integer.compare(Math.abs(a-x),Math.abs(b-x));
            return (val == 0) ? Integer.compare(a,b) : val;
        });

        for(int n : arr) pq.offer(n);

        List<Integer> res = new ArrayList<>();
        while(k-- > 0) res.add(pq.poll());
        Collections.sort(res);

        return res;
    }
}