class Solution {
    private void dfs(int cur,ArrayList<Integer> arr,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[cur]=true;
        arr.add(cur);
        for(int i:adj.get(cur)){
            if(!vis[i]){
                dfs(i,arr,vis,adj);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v=adj.size();
        boolean[] vis=new boolean[v];
        ArrayList<Integer> arr=new ArrayList<>();
        dfs(0,arr,vis,adj);
        return arr;
    }
}