class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> op = new ArrayList<>();
        int size = 1 << n;
        for (int i = 0; i < size; i++) {
            op.add(i ^ (i >> 1));
        }
        return op;
    }
}