class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int w2 = 1; 
        int w1 = 2; 
        for (int i = 3; i <= n; i++) {
            int wc = w1 + w2;
            w2 = w1;
            w1 = wc;
        }
        return w1;
    }
}