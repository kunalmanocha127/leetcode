class Solution {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];
        int op = 1;
        for (int i = 0; i < n; i++){
            op = Math.max(op, dfs(i, arr, d));
        }
        return op;
    }

    private int dfs(int i, int[] arr, int d) {
        if (dp[i] != 0) return dp[i];
        int b = 1;
        for (int nxt = i + 1; nxt <= Math.min(arr.length - 1, i + d); nxt++){
            if (arr[nxt] >= arr[i]) break;
            b = Math.max(b, 1 + dfs(nxt, arr, d));
        }
        for (int nxt = i - 1; nxt >= Math.max(0, i - d); nxt--){
            if (arr[nxt] >= arr[i]) break;
            b = Math.max(b, 1 + dfs(nxt, arr, d));
        }
        return dp[i] = b;
    }
}