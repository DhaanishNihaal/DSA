class Solution {
    private int helper(int ind,int[] nums,int[] dp){
        if(ind==0) return nums[0];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int a=helper(ind-1,nums,dp);
        int b=helper(ind-2,nums,dp)+nums[ind];
        dp[ind]=Math.max(a,b);
        return dp[ind];
    }
    public int rob(int[] nums) {
        int [] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,nums,dp);
    }
}