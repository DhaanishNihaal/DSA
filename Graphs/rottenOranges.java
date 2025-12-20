class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int []> q=new ArrayDeque<>();
        int fc=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) fc++;
            }
        }
        if(fc==0) return 0;
        int[] x={0,0,-1,1};
        int[] y={-1,1,0,0};
        int rowl=grid.length;
        int coll=grid[0].length;
        int c=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int k=0;k<len;k++){
                int[] list=q.poll();  
                for(int i=0;i<=3;i++){
                    int row=list[0]+x[i];
                    int col=list[1]+y[i];
                    if(row<rowl && col<coll && row>=0 && col>=0 && grid[row][col]==1){
                        grid[row][col]=2;
                        fc--;
                        q.add(new int[]{row,col});
                    }
                }
            }
            c++;
        }
        if(fc==0) return c-1;
        return -1;
    }
}