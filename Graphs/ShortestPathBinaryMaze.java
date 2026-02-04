class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        ArrayDeque<int[]> que=new ArrayDeque<>();
        que.add(new int[]{1,0,0});
        int [] arrx={0,0,1,-1,1,-1,1,-1};
        int [] arry={1,-1,0,0,1,-1,-1,1};
        int n=grid.length;
        if(grid[0][0]==1) return -1;
        while(!que.isEmpty()){
            int[] cur=que.poll();
            int curLev=cur[0];
            int curx=cur[1];
            int cury=cur[2];
            if(curx==n-1 && cury==n-1) return curLev;
            for(int i=0;i<=7;i++){
                int x=curx+arrx[i];
                int y=cury+arry[i];
                if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==0){
                    grid[x][y]=1;
                    que.add(new int[]{curLev+1,x,y});
                }

            }
        }
        return -1;
    }
}