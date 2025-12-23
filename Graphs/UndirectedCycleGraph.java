class Solution {
    private boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] path){
        vis[node]=true;
        path[node]=true;
        for(int nei:adj.get(node)){
            if(!vis[nei]){
                if(dfs(nei,adj,vis,path))
                    return true;
            }
            else if(path[nei]){
                return true;
            }
        }
        path[node]=false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
        }
        boolean[] vis=new boolean[V];
        boolean[] path=new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, path)) return true;
                }
            }
    return false;

    }
}