class Solution {
    private static final int mod = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return (int) pow(2, dfs(1, 0, graph) - 1);
    }

    private int dfs(int node, int prev, List<Integer>[] graph){
        int d = 0;
        for (int g : graph[node]){
            if (g != prev) d = Math.max(d, dfs(g, node, graph) + 1);
        }
        return d;
    }

    private long pow(long base, int exp){
        long op = 1;
        while (exp > 0){
            if (exp % 2 > 0) op = op * base % mod;
            base = base * base % mod;
            exp /= 2;
        }
        return op;
    }
}