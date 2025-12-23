class Solution {
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] ind=new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            ind[edge[1]]++;
        }
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(ind[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int nei:adj.get(cur)){
                ind[nei]--;
                if(ind[nei]==0)
                    q.add(nei);
            }
            arr.add(cur);
        }
        return arr;
    }
}