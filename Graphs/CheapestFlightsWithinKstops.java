class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] flight:flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[][] dist=new int[n][k+2];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        PriorityQueue<int []> que =new PriorityQueue<>((a,b)->a[0]-b[0]);
        que.add(new int[]{0,src,0});
        dist[src][0]=0;
        while(!que.isEmpty()){
            int cur[]=que.poll();
            int curStop=cur[1];
            int curPrice=cur[0];
            int curK=cur[2];
            if(curStop==dst) return curPrice;
            if(curK>k) continue;
            for(int neigh[]:adj.get(curStop)){
                int curCost=neigh[1]+curPrice;
                if(curCost<dist[neigh[0]][curK+1]){
                    dist[neigh[0]][curK+1]=curCost;
                    que.add(new int[]{curCost,neigh[0],curK+1});
                }
            }
        }
        return -1;
    }
}
//simple and best
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] flight:flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayDeque<int []> que =new ArrayDeque<>();
        que.add(new int[]{0,src,0});
        dist[src]=0;
        while(!que.isEmpty()){
            int cur[]=que.poll();
            int curStop=cur[1];
            int curPrice=cur[0];
            int curK=cur[2];
            if(curStop==dst){
                dist[src]=Math.min(dist[src],curStop);
                continue;
            };
            if(curK>k) continue;
            for(int neigh[]:adj.get(curStop)){
                int curCost=neigh[1]+curPrice;
                if(curCost<dist[neigh[0]]){
                    dist[neigh[0]]=curCost;
                    que.add(new int[]{curCost,neigh[0],curK+1});
                }
            }
        }
        if(dist[dst]!=Integer.MAX_VALUE) return dist[dst];
        return -1;
    }
}