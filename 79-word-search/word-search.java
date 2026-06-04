public class Solution {
    public boolean exist(char[][] b, String w) {
        int m = b.length;
        int n = b[0].length;
        boolean[][] v = new boolean[m][n];
        boolean res = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == w.charAt(0)) {
                    res = backtrack(b, w, v, i, j, 0);
                    if (res) return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] b, String w, boolean[][] v, int i, int j, int id){
        if (id == w.length()) return true;
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length || v[i][j] || b[i][j] != w.charAt(id)) return false;
        v[i][j] = true;
        if (backtrack(b, w, v, i+1, j, id+1)||backtrack(b, w, v, i-1, j, id+1) ||
            backtrack(b, w, v, i, j+1, id+1)||backtrack(b, w, v, i, j-1, id+1)) return true;
        v[i][j] = false;
        return false;
    }
}