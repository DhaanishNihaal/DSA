class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        dist[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[] {0,src});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int curNd=cur[1];
            int curDis=cur[0];
            for(int[] neigh:adj.get(curNd)){
                if(dist[neigh[0]]>dist[curNd]+neigh[1]){
                    dist[neigh[0]] = dist[curNd]+neigh[1];
                    pq.add(new int[]{dist[neigh[0]],neigh[0]});
                }
            }
        }
        return dist;
    }
}