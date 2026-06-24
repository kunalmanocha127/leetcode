class Solution{
    static final int MOD = 1_000_000_007;
    private long[][] multiplyMatrices(long[][] matA, long[][] matB){
        int size = matA.length;
        long[][] op = new long[size][size];
        for (int row = 0; row < size; row++){
            for (int mid = 0; mid < size; mid++){
                if (matA[row][mid] == 0) continue;
                for (int col = 0; col < size; col++){
                    op[row][col] = (op[row][col] + matA[row][mid] * matB[mid][col]) % MOD;
                }
            }
        }
        return op;
    }
    private long[][] matrixPower(long[][] matrix, int power){
        int size = matrix.length;
        long[][] op = new long[size][size];
        for (int row = 0; row < size; row++) op[row][row] = 1;
        while (power > 0){
            if ((power & 1) == 1) op = multiplyMatrices(op, matrix);
            matrix = multiplyMatrices(matrix, matrix);
            power >>= 1;
        }
        return op;
    }
    public int zigZagArrays(int n, int l, int r){
        int valueCount = r - l + 1;
        long[] initialDp = new long[valueCount];
        for (int i = 0; i < valueCount; i++){
            initialDp[i] = i;
        }
        long[][] transitionMatrix = new long[valueCount][valueCount];
        for (int row = 1; row < valueCount; row++){
            for (int col = valueCount - row; col < valueCount; col++){
                transitionMatrix[row][col] = 1;
            }
        }
        long[][] poweredTransition = matrixPower(transitionMatrix, n - 2);
        long answer = 0;
        for (int row = 0; row < valueCount; row++){
            for (int col = 0; col < valueCount; col++){
                answer = (answer + poweredTransition[row][col] * initialDp[col]) % MOD;
            }
        }
        return (int)(answer * 2 % MOD);
    }
}