class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        final int NEG = -1_000_000_000;
        int[][] prev = new int[n][k + 1];
        for (int j = 0; j < n; j++) {
            Arrays.fill(prev[j], NEG);
        }
        for (int i = 0; i < m; i++) {
            int[][] curr = new int[n][k + 1];
            for (int j = 0; j < n; j++) {
                Arrays.fill(curr[j], NEG);
            }
            for (int j = 0; j < n; j++) {
                int g = grid[i][j];
                int rq = g > 0 ? 1 : 0;
                int lm = Math.min(k, i + j);
                if (i == 0 && j == 0) {
                    curr[0][0] = 0;
                    continue;
                }
                for (int c = rq; c <= lm; c++) {
                    int best = NEG;
                    if (i > 0 && prev[j][c - rq] != NEG) {
                        best = Math.max(best, prev[j][c - rq] + g);
                    }
                    if (j > 0 && curr[j - 1][c - rq] != NEG) {
                        best = Math.max(best, curr[j - 1][c - rq] + g);
                    }
                    curr[j][c] = best;
                }
            }
            prev = curr;
        }
        int op = NEG;
        for (int c = 0; c <= k; c++) {
            op = Math.max(op, prev[n - 1][c]);
        }
        return op < 0 ? -1 : op;
    }
}