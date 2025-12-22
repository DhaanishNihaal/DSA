class Solution {
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
        Deque<int []> q=new ArrayDeque<>();
        for(int k=0;k<V;k++){
            if(!vis[k]){
                q.add(new int[]{k,-1});
                vis[k]=true;
                while(!q.isEmpty()){
                    int[] cur=q.poll();
                    for(int i:adj.get(cur[0])){
                        if(vis[i] && i!=cur[1]) return true;
                        if(!vis[i]){
                            vis[i]=true;
                            q.add(new int[]{i,cur[0]});
                        }
                    }
                }
            }
        }
        return false;
    }
}