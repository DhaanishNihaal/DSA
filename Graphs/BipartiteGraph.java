class Solution {
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        Deque<Integer> q=new ArrayDeque<>();
        int[] col=new int[v];
        Arrays.fill(col,-1);
        for(int i=0;i<v;i++){
            if(col[i]==-1){
                col[i]=0;
                q.add(i);
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int nei:graph[node]){
                        if(col[nei]==-1){
                            col[nei]=1-col[node];
                            q.add(nei);
                        }
                        else if(col[nei]==col[node])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
//dfs
public boolean dfs(int[][] graph,int []colors,int v,int c) {
        colors[v] = c;
        for(int ne: graph[v]) {
            if(colors[ne] == -1) {
                if(dfs(graph,colors,ne,1-c) == false)
                    return false;
            } 
            else if(colors[ne] == c) 
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        //DFS

        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color,-1);
        for(int i=0;i<v;i++) {
            if(color[i] == -1) {
                if(dfs(graph,color,i,0) == false)
                    return false;
            }
        }
        return true; 
    }
}