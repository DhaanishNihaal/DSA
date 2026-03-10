class Solution {
    private int f(int ind,int[] nums,int[][] dp,int flag){
        if(ind==0){
            if(flag==1) return 0;
            else return nums[0];
        }
        if(ind<0) return 0;
        if(dp[ind][flag]!=-1) return dp[ind][flag];
        int a=f(ind-1,nums,dp,flag);
        int b=0;
        if(ind==nums.length-1){
            b=f(ind-2,nums,dp,1)+nums[ind];
        }
        else{
            b=f(ind-2,nums,dp,flag)+nums[ind];
        }
        dp[ind][flag]=Math.max(a,b);
        return dp[ind][flag];
        
    }
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return  f(nums.length-1,nums,dp,0);
    }
}