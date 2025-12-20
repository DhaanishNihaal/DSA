//bfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc=image[sr][sc];
        if(oc==color) return image;
        int[] x={0,0,-1,1};
        int[] y={-1,1,0,0};
        int row_l=image.length;
        int col_l=image[0].length;
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<=3;i++){
                int row=cur[0]+x[i];
                int col=cur[1]+y[i];
                if(row<row_l && col <col_l && row>-1 && col>-1 && image[row][col]==oc){
                    image[row][col]=color;
                    q.add(new int[]{row,col});
                }
            }
        }
        return image;
    }
}

//dfs
class Solution {
    int[] x={0,0,-1,1};
    int[] y={-1,1,0,0};
    private void dfs(int[][] image,int sr,int sc,int color,int oc){
        image[sr][sc]=color;
        for(int i=0;i<=3;i++){
            int row=sr+x[i];
            int col=sc+y[i];
            if(row>-1 && col>-1 && row<image.length && col<image[0].length && image[row][col]==oc){
                dfs(image,row,col,color,oc);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc=image[sr][sc];
        if(oc!=color) dfs(image,sr,sc,color,oc);
        return image;
    }
}