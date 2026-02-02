class Solution {
    class Pair{
        int val;
        int level;
        public Pair(int val,int level){
            this.val=val;
            this.level=level;
        }
    }
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        int ans[] = new int[V];
        Arrays.fill(ans,-1);
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int edge[]: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src,0));
        ans[src]=0;
        
        while(!que.isEmpty()){
            Pair cur=que.poll();
            int curVal=cur.val;
            int curLev=cur.level+1;
            for(int i:adj.get(curVal)){
                if(ans[i]==-1 ){
                    ans[i]=curLev;
                    que.add(new Pair(i,curLev));
                }
                
            }
        }
        return ans;
    }
}
