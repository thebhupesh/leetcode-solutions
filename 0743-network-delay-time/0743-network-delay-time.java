class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] val: times) {
            List<int[]> curr = map.getOrDefault(val[0],new ArrayList<>());
            curr.add(new int[]{val[1],val[2]});
            map.put(val[0],curr);
        }

        int remaining = n;
        int res = 0;
        boolean[] processed = new boolean[n+1];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{k,0});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(processed[curr[0]]) continue;

            processed[curr[0]] = true;
            res = Math.max(res,curr[1]);
            remaining--;

            List<int[]> adj = map.get(curr[0]);
            if(adj == null) continue;
            
            for(int[] val : adj) {
                if(!processed[val[0]]) q.offer(new int[]{val[0],val[1]+curr[1]});
            }
        }

        return (remaining == 0) ? res : -1;
    }
}