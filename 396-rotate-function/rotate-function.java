class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0, F = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            F += i * A[i];
        }
        int op = F;
        for (int i = 1; i < n; i++) {
            F += sum - n * A[n - i];
            op = Math.max(op, F);
        }
        return op;
    }
}