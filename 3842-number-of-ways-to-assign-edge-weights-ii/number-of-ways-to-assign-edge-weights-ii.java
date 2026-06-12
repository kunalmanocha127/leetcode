class Solution {
    static int[] bex;
    static final long mod = 1000000007l;
    static{
        bex = new int[100001];
        long pro = 1l;
        for (int i = 1; i < bex.length; i++){
            bex[i] = (int) (pro);
            pro = (pro * 2l) % mod;
        }
    }
    
    int[][] anc;
    int[] ans, prnt, dpt;
    boolean[] vis;

    private void banc(int[] prnt, int numNodes) {
        anc = new int[(int) (Math.log(numNodes) / Math.log(2)) + 1][numNodes + 1];
        int n = anc.length, m = anc[0].length;
        for (int i = 0; i < m; i++) anc[0][i] = prnt[i];
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++) anc[i][j] = anc[i - 1][anc[i - 1][j]];
        }
    }

    public int[] assignEdgeWeights(int[][] edg, int[][] qry) {
        int n = edg.length, q = qry.length;
        ans = new int[q];
        prnt = new int[n + 2];
        vis = new boolean[n + 2];
        dpt = new int[n + 2];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edg.length; i++){
            adj.get(edg[i][0]).add(edg[i][1]);
            adj.get(edg[i][1]).add(edg[i][0]);
        }
        prnt[1] = 1;
        dfs(1, adj, 0);
        banc(prnt, n + 1);
        for (int i = 0; i < q; i++) ans[i] = bex[gpc(qry[i][0], qry[i][1])];
        return ans;
    }

    private int gpc(int u, int v) {
        int dptU = dpt[u], dptV = dpt[v], lca = -1;
        if (dptU > dptV) lca = LCA(u, v);
        else lca = LCA(v, u);
        return dpt[u] + dpt[v] - 2 * dpt[lca];
    }

    private int LCA(int u, int v) {
        int dptU = dpt[u];
        int dptV = dpt[v];
        int diff = dptU - dptV;
        int mask = 1, idx = 0;
        while (mask <= diff){
            if ((mask & diff) > 0) u = anc[idx][u];
            mask <<= 1;
            idx++;
        }
        if (u == v) return u;
        int maxJumps = anc.length - 1;
        while (maxJumps >= 0){
            if (anc[maxJumps][u] != anc[maxJumps][v]){
                u = anc[maxJumps][u];
                v = anc[maxJumps][v];
            }
            maxJumps--;
        }
        int lca = anc[0][u];
        return lca;
    }

    private void dfs(int node, List<List<Integer>> adj, int dptValue) {
        vis[node] = true;
        dpt[node] = dptValue;
        List<Integer> children = adj.get(node);
        for (int v : children){
            if (vis[v]) continue;
            prnt[v] = node;
            dfs(v, adj, dptValue + 1);
        }
    }
}