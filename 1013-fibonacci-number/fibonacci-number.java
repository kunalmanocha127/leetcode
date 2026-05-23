class Solution {
    static int[] dp;
    public int fibo(int n) {
        if (n == 1 || n == 0) return n;
        if (dp[n] != 0) return dp[n];
        int sum = fibo(n - 1) + fibo(n - 2);
        dp[n] = sum;
        return sum;
    }

    public int fib(int n) {
        dp = new int[n + 1];
        return fibo(n);
    }
}