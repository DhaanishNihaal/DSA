class Solution {
    private boolean dfs(int curr,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int parent){
        for(int i:adj.get(curr)){
            if(!vis[i]){
                vis[i]=true;
                if(dfs(i,adj,vis,curr)) return true;;
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);

        }
        boolean[] vis=new boolean[V];
        for(int k=0;k<V;k++){
            if(!vis[k]){
                vis[k]=true;
                if(dfs(k,adj,vis,-1)) return true;
            }
        }
        return false;
    }
}