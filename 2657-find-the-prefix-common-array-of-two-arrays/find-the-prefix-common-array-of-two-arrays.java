class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int count = 0;
        int[] arr = new int[n];
        boolean[] w = new boolean[n];
        for (int i = 0; i < n; i++){
            if (w[A[i] - 1]) count++;
            else w[A[i] - 1] = true;
            if (w[B[i] - 1]) count++;
            else w[B[i] - 1] = true;
            arr[i] = count;
        }
        return arr;
    }
}