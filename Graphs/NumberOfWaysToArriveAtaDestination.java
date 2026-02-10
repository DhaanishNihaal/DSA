class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] road: roads){
            adj.get(road[0]).add(new int[]{road[1],road[2]});
            adj.get(road[1]).add(new int[]{road[0],road[2]});
        }
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        long[] ways=new long[n];
        Arrays.fill(ways,0);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<long[]> que=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        que.add(new long[]{0,0});
        while(!que.isEmpty()){
            long[] cur=que.poll();
            int curVal=(int)cur[1];
            long curCost=cur[0];
            for(int neigh[]:adj.get(curVal)){
                long tempCost=curCost+neigh[1];
                if(dist[neigh[0]]>tempCost) {
                    ways[neigh[0]]=ways[curVal];
                    dist[neigh[0]]=tempCost;
                    que.add(new long[]{tempCost,neigh[0]});
                }
                else if(dist[neigh[0]]==tempCost) {
                    ways[neigh[0]]=(ways[neigh[0]]+ways[curVal])%1_000_000_007;
                }
            }
        }
        return (int)(ways[n-1]%1_000_000_007); 

    }
}