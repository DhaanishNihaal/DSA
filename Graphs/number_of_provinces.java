//dfs
class Solution {
    int n;
    private void dfs(int v,int[][] isConnected,boolean[] vis){
        for(int i=0;i<n;i++){
            if(isConnected[v][i]==1){
                if(!vis[i]){
                    vis[i]=true;
                    dfs(i,isConnected,vis);
                }
            }
        }
    }
    private void bfs(int x,int[][] isConnected,boolean[] vis){
        Deque<Integer> q=new ArrayDeque<>();
        q.add(x);
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int i=0;i<n;i++){
                if(!vis[i] && isConnected[cur][i]==1){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        n=isConnected.length;
        boolean vis[]=new boolean[n+1];
        int c=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                dfs(i,isConnected,vis);
                c++;
            }
        }
        return c;
    }
}
//bfs
