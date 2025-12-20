class Solution {
    private void dfs(int x,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> cur){
        cur.add(x);
        for(int i:adj.get(x)){
            if(!vis[i]){
                vis[i]=true;
                dfs(i,adj,vis,cur);
            }
        }
    }
    private void bfs(int x,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> cur){
        Deque<Integer> q=new ArrayDeque<>();
        q.add(x);
        while(!q.isEmpty()){
            int val=q.poll();
            cur.add(val);
            for(int nei:adj.get(val)){
                if(!vis[nei]){
                vis[nei]=true;
                q.add(nei);
                }
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] lis:edges){
            adj.get(lis[0]).add(lis[1]);
            adj.get(lis[1]).add(lis[0]);
        }
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        boolean[] vis=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                vis[i]=true;
                ArrayList<Integer> cur =new ArrayList<>();
                bfs(i,adj,vis,cur);
                arr.add(cur);
            }
        }
        return arr;
    }
}