class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] op = new int[n];
        int[] pm = new int[n];
        pm[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pm[i] = Math.max(pm[i - 1], nums[i]);
        }
        int sm = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (pm[i] > sm)
                op[i] = op[i + 1];
            else
                op[i] = pm[i];
            sm = Math.min(sm, nums[i]);
        }
        return op;
    }
}