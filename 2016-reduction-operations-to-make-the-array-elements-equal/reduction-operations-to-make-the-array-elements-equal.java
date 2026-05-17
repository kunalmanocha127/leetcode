class Solution {
    public int reductionOperations(int[] n) {
        int count = 0, sz = n.length;
        Arrays.sort(n);
        for (int i = sz - 1; i > 0; --i){
            if (n[i - 1] != n[i]) count += sz - i;
        }
        return count;
    }
}