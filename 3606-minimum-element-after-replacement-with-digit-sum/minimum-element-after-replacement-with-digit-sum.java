class Solution {
    public int minElement(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int sum = 0;
            for(int j = n; j > 0; j/=10){
                int d = j % 10;
                sum += d;
            }
            nums[i] = sum;
        }
        Arrays.sort(nums);
        return nums[0];
    }
}