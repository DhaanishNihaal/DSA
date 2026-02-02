// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        int ans[] = new int[V];
        Arrays.fill(ans,-1);
        ArrayList<ArrayList<int []>> adj= new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int edge[]: edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        ArrayDeque<int []> que = new ArrayDeque<>();
        que.add(new int[] {0,0});
        ans[0]=0;
        while(!que.isEmpty()){
            int[] cur=que.poll();
            int curVal=cur[0];
            int curLev=cur[1];
            for(int[] neigh:adj.get(curVal)){
                int neighLev=curLev+neigh[1];
                if(ans[neigh[0]]==-1 || ans[neigh[0]]>neighLev){
                    ans[neigh[0]]=neighLev;
                    que.add(new int[]{neigh[0],neighLev});
                }
                
            }
        }
        return ans;
    }
}