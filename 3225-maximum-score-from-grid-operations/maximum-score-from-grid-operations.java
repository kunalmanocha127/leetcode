class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (m == 1) return 0;
        long[][] col = new long[m][n + 1];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                col[j][i + 1] = col[j][i] + grid[i][j];
            }
        }
        long[][] dp = new long[n + 1][n + 1];
        long[][] pm = new long[n + 1][n + 1];
        long[][] sm = new long[n + 1][n + 1];
        for (int c = 1; c < m; c++) {
            long[][] newdp = new long[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i <= j) {
                        long gain = col[c][j] - col[c][i];
                        newdp[i][j] = Math.max(
                                newdp[i][j],
                                sm[j][0] + gain
                        );
                    }
                    else {
                        long gain = col[c - 1][i] - col[c - 1][j];
                        newdp[i][j] = Math.max(
                                newdp[i][j],
                                Math.max(
                                        sm[j][i],
                                        pm[j][i] + gain
                                )
                        );
                    }
                }
            }
            for (int i = 0; i <= n; i++) {
                pm[i][0] = newdp[i][0];
                for (int j = 1; j <= n; j++) {
                    long penalty = 0;
                    if (j > i)
                        penalty = col[c][j] - col[c][i];
                    pm[i][j] = Math.max(
                            pm[i][j - 1],
                            newdp[i][j] - penalty
                    );
                }
                sm[i][n] = newdp[i][n];
                for (int j = n - 1; j >= 0; j--) {
                    sm[i][j] = Math.max(
                            sm[i][j + 1],
                            newdp[i][j]
                    );
                }
            }
            dp = newdp;
        }
        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[0][k], dp[n][k]));
        }
        return ans;
    }
}