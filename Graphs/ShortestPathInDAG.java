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
// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        int ind[] = new int[V];
        int ans[] = new int[V];
        Arrays.fill(ans,-1);
        ArrayList<ArrayList<int []>> adj= new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int edge[]: edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            ind[edge[1]]++;
        }
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i=0;i<V;i++) {
            if(ind[i]==0) que.add(i);
        }
        int[] topo=new int[V];
        int idx=0;
        while(!que.isEmpty()){
            int cur=que.poll();
            topo[idx++]=cur;
            for(int[] neigh:adj.get(cur)){
                ind[neigh[0]]--;
                if(ind[neigh[0]]==0){
                    que.add(neigh[0]);
                }
            }
        }
        ans[0]=0;
        for(int i=0;i<V;i++){
            if(ans[topo[i]]==-1) continue;
            for(int[] neigh:adj.get(topo[i])){
                if(ans[neigh[0]]==-1 || ans[neigh[0]]>ans[topo[i]]+neigh[1]) ans[neigh[0]] = ans[topo[i]]+neigh[1];
            }
        }
        return ans;
    }
}