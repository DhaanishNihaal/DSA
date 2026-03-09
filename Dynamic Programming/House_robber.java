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
        int n=nums.length;
        int [] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        if(n==1) return nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
        // return helper(nums.length-1,nums,dp);
    }
}