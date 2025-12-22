// User function Template for Java

class Solution {
    int[] x={0,0,-1,1};
    int[] y={-1,1,0,0};
    private String bfs(int[][] grid,int sr,int sc){
        StringBuilder res=new StringBuilder();
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc});
        grid[sr][sc]=0;
        res.append("0 0");
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<4;i++){
                int nr=cur[0]+x[i],nc=cur[1]+y[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    q.add(new int[]{nr,nc});
                    grid[nr][nc]=0;
                    res.append(","+Integer.toString(nr-sr)+" "+Integer.toString(nc-sc));
                }
            }
        }
        return res.toString();
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    set.add(bfs(grid,i,j));
                }
            }
        }
        return set.size();
    }
}
