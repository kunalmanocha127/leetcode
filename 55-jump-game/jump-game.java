class Solution {
    public boolean canJump(int[] nums) {
        Boolean[]arr=new Boolean[nums.length];
        return helper(nums,arr,0);
    }
    public boolean helper(int[]nums,Boolean []dp,int ix){
        if(ix>=nums.length)return false;
        if(ix==nums.length-1)return true;
        if(dp[ix]!=null)return dp[ix];
        for(int i=1;i<=nums[ix];i++){
            if(helper(nums,dp,ix+i)){
                dp[ix]=true;
                return true;
            }
        }
        dp[ix]=false;
        return false;
    }
}