class Solution {
    private boolean isPossible(int curr, boolean[] visited, List<Integer>[] adj, boolean[] marked) {
        if(marked[curr]) return false;
        if(visited[curr]) return true;

        visited[curr] = true;
        marked[curr] = true;

        if(adj[curr] != null) {
            for(int course : adj[curr]) {
                if(!isPossible(course, visited, adj, marked)) return false;
            }
        }

        marked[curr] = false;

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];

        for(int[] prerequisite : prerequisites) {
            if(adj[prerequisite[0]] == null) adj[prerequisite[0]] = new ArrayList<>();
            adj[prerequisite[0]].add(prerequisite[1]);
        }

        boolean[] visited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i] && !isPossible(i, visited, adj, new boolean[numCourses])) return false;
        }

        return true;
    }
}