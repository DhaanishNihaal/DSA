class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] time:times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        int[]  dist=new int[n+1];
        Queue<int []> que=new LinkedList<>();
        que.add(new int[]{0,k});
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!que.isEmpty()){
            int[] cur=que.poll();
            int curVal=cur[1];
            int curCost=cur[0];
            for(int[] neigh:adj.get(curVal)){
                if(dist[neigh[0]]>curCost+neigh[1]){
                    dist[neigh[0]]=curCost+neigh[1];
                    que.add(new int[]{curCost+neigh[1],neigh[0]});
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(dist[i],ans);
        }
        return ans;
    }
}