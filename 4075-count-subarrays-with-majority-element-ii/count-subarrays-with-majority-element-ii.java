class Solution{
    public long countMajoritySubarrays(int[] nums, int target){
        int n = nums.length;
        int[] freq = new int[2 * n + 1];
        freq[n] = 1;
        long less = 0;
        long ans = 0;
        for (int num : nums){
            if (num == target){
                less += freq[n];
                n++;
            }
            else{
                n--;
                less -= freq[n];
            }
            freq[n]++;
            ans += less;
        }
        return ans;
    }
}