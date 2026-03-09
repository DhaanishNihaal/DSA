class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] dp=new int[n];
        dp[0]=0
        if(n==1) return 0;
        dp[1]=Math.abs(height[0]-height[1]);
        int a,b;
        for(int i=2;i<n;i++){
            a=dp[i-1]+Math.abs(height[i]-height[i-1]);
            b=dp[i-2]+Math.abs(height[i]-height[i-2]);
            dp[i]=Math.min(a,b);
        }
        return dp[n-1];
    }
}