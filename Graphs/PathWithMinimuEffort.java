class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        boolean[][] vis=new boolean[n][m];
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b)->a[0]-b[0]);
        que.add(new int[]{0,0,0});
        int [] x={0,0,1,-1};
        int[] y={1,-1,0,0};
        while(!que.isEmpty()){
            int[] cur=que.poll();
            int curEff=cur[0];
            int curX=cur[1];
            int curY=cur[2];
            if(vis[curX][curY]) continue;
            vis[curX][curY]=true;
            if(curX==n-1 && curY==m-1) return curEff;
            for(int i=0;i<4;i++){
                int tx=curX+x[i];
                int ty=curY+y[i];
                if(tx<n && ty<m && ty>=0 && tx>=0 && !vis[tx][ty]){
                    int eff=Math.max(curEff,Math.abs(heights[curX][curY]-heights[tx][ty]));
                    que.add(new int[]{eff,tx,ty});
                }
            }
        }
        return -1;
    }
}