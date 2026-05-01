class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> op = new ArrayList<>();
        gc(1, n, k, new ArrayList<Integer>(), op);
        return op;
    }

    private void gc(int start, int n, int k, List<Integer> cc, List<List<Integer>> op){
        if (k == 0) {
            op.add(new ArrayList<>(cc));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            cc.add(i);
            gc(i + 1, n, k - 1, cc, op);
            cc.remove(cc.size() - 1);
        }
    }
}