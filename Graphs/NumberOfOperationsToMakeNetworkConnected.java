class Solution {
    private int find(int[] par,int x){
        if(par[x]==x) return x;
        int node=find(par,par[x]);
        par[x]=node;
        return node;
    }
    private void union(int[] par,int[] rank ,int x,int y){
        int upx=find(par,x);
        int upy=find(par,y);
        if(rank[upx]<rank[upy]){
            par[upx]=upy;
        }
        else if(rank[upy]<rank[upx]){
            par[upy]=upx;
        }
        else{
            par[upy]=upx;
            rank[upx]+=1;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int k=connections.length;
        if(k<n-1){
            return -1; 
        }
        int[] par=new int[n];
        int[] rank=new int[n];
        Arrays.fill(rank,1);
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        for(int[] edge:connections){
            union(par,rank,edge[0],edge[1]);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(find(par,i)==i){
                c++;
            }
        }
        return c-1;

    }
}