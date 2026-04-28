class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] nums = new int[m * n];
        int in = 0;
        for (int[] row : grid) {
            for (int k : row) {
                nums[in] = k;
                in++;
            }
        }
        Arrays.sort(nums);
        int t = nums[nums.length / 2];
        int op = 0;
        for (int k : nums) {
            int temp = Math.abs(k - t);
            if (temp % x != 0) return -1;
            op += temp / x;
        }
        return op;
    }
}