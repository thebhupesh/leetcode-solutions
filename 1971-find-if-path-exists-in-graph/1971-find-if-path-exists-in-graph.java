class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        visited[source] = true;

        while(!stack.isEmpty()) {
            int curr = stack.pop();

            if(curr == destination) return true;

            for(int vertice : adj.get(curr)) {
                if(!visited[vertice]) {
                    stack.push(vertice);
                    visited[vertice] = true;
                }
            }
        }

        return false;
    }
}