class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int tsum = 0;
        int cmax = 0;
        int maxs = nums[0];
        int cmin = 0;
        int mins = nums[0];
        for(int num : nums){
            tsum += num;
            cmax = Math.max(num, cmax + num);
            maxs = Math.max(maxs, cmax);
            cmin = Math.min(num, cmin + num);
            mins = Math.min(mins, cmin);
        }
        int cirs = tsum - mins;
        if(cirs == 0) return maxs;
        return Math.max(maxs, cirs);
    }
}