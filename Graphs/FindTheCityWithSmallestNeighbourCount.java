class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMat=new int[n][n];
        for(int[] arr:adjMat){
            Arrays.fill(arr,(int)1e5);
        }
        for(int i=0;i<n;i++){
            adjMat[i][i]=0;
        }
        for(int[] edge:edges){
            adjMat[edge[0]][edge[1]]=edge[2];
            adjMat[edge[1]][edge[0]]=edge[2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(adjMat[i][k]==1e5 || adjMat[k][j]==1e5) continue;
                    adjMat[i][j]=Math.min(adjMat[i][k]+adjMat[k][j],adjMat[i][j]);
                }
            }
        }
        int ans=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(adjMat[i][j]<=distanceThreshold) c++;
            }
            if(min>=c){
                min=c;
                ans=i;
            }
        }
        return ans;
    }
}