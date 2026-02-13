class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int[] vis=new int[V];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.add(new int[]{0,0});
        int sum=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int nd=cur[1];
            int wt=cur[0];
            if(vis[nd]==1) continue;
            vis[nd]=1;
            sum+=wt;
            for(int[] nei:adj.get(nd)){
                if(vis[nei[0]]==0){
                    q.add(new int[]{nei[1],nei[0]});
                }
            }
        }
        return sum;
        
    }
}
