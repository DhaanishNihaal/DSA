class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] ind=new int[V];
        int vis=0;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
            ind[arr[1]]++;
        }
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(ind[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            vis++;
            for(int edge:adj.get(cur)){
                ind[edge]--;
                if(ind[edge]==0){
                    q.add(edge);
                }
            }
        }
        return vis<V;      

    }
}