class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = new int[(limit << 1) + 2];
        for (int i = 0; i < n >> 1; i++){
            int min = Math.min(nums[i], nums[n-1-i]);
            int max = Math.max(nums[i], nums[n-1-i]);
            arr[2] += 2;
            arr[min+1]--;
            arr[min+max]--;
            arr[min+max+1]++;
            arr[max+limit+1]++;
        }
        int op = n, m = 0;
        for (int targ = 2; targ <= limit*2; targ++){
            m += arr[targ];
            op = Math.min(op, m);
        }
        return op;
    }
}