class Solution {
    int n;
    void dfs(int i,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> arr,boolean[] vis){
        vis[i]=true;
        for(int nei:adj.get(i)){
            if(!vis[nei]){
                dfs(nei,adj,arr,vis);
            }
        }
        arr.set(n,i);
        n--;
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        n=V-1;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            arr.add(0);
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] vis= new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,arr,vis);
            }
        }
        return arr;
    }
}