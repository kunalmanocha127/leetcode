class Solution{
    public int[] minEdgeReversals(int n, int[][] edges){
        List<int[]>[] gp = new List[n];
        for (int i = 0; i < n; i++){
            gp[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int from = edge[0], to = edge[1];
            gp[from].add(new int[]{1, to});    
            gp[to].add(new int[]{-1, from});   
        }
        int[] op = new int[n];
        Arrays.fill(op, -1);
        op[0] = dfs(gp, 0, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            int cc = op[node];
            for (int[] nb : gp[node]){
                int d = nb[0];
                int nn = nb[1];
                if (op[nn] == -1){
                    op[nn] = d == 1
                        ? cc + 1
                        : cc - 1;
                    queue.add(nn);
                }
            }
        }
        return op;
    }

    private int dfs(List<int[]>[] gp, int node, int parent){
        int c = 0;
        for (int[] nb : gp[node]){
            int d = nb[0];
            int nn = nb[1];
            if (nn == parent) continue;
            if (d == -1) c++;   
            c += dfs(gp, nn, node);
        }
        return c;
    }
}