import java.util.*;
public class Solution {
    public static int f(int ind,int[][] points,int act,int[][] dp){
        if(ind==0) return points[ind][act];
        if(dp[ind][act]!=-1) return dp[ind][act];
        if(act==0){
            return dp[ind][act] = Math.max(points[ind][0]+f(ind-1,points,1,dp),points[ind][0]+f(ind-1,points,2,dp));
        }
        if(act==1){
            return dp[ind][act]= Math.max(points[ind][1]+f(ind-1,points,0,dp),points[ind][1]+f(ind-1,points,2,dp));
        }
        if(act==2){
            return dp[ind][act]=Math.max(points[ind][2]+f(ind-1,points,0,dp),points[ind][2]+f(ind-1,points,1,dp));
        }
        return 0;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp=new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=points[0][0];
        dp[0][1]=points[0][1];
        dp[0][2]=points[0][2];

        for(int ind=1;ind<n;ind++){
            for(int act=0;act<3;act++){
                if(act==0){
                    dp[ind][0]=Math.max(points[ind][0]+dp[ind-1][1],points[ind][0]+dp[ind-1][2]);
                }
                if(act==1){
                    dp[ind][1]=Math.max(points[ind][1]+dp[ind-1][0],points[ind][1]+dp[ind-1][2]);
                }
                if(act==2){
                    dp[ind][2]=Math.max(points[ind][2]+dp[ind-1][0],points[ind][2]+dp[ind-1][1]);
                }
            }
        }
        return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
        // int a=f(n-1,points,0,dp);
        // int b=f(n-1,points,1,dp);
        // int c=f(n-1,points,2,dp);
        // return Math.max(a,Math.max(b,c));

    }

}