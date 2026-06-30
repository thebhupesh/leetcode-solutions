class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] inDegree = new int[numCourses];

        for(int[] val : prerequisites) {
            if(adj[val[0]] == null) {
                adj[val[0]] = new ArrayList<>();
            }

            adj[val[0]].add(val[1]);
            inDegree[val[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int resolved = 0;

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            resolved++;

            if(adj[curr] != null) {
                for(int i : adj[curr]) {
                    inDegree[i]--;
                    if(inDegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }

        return numCourses == resolved;
    }
}