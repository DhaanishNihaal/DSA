class Solution {
    int[] x={0,0,-1,1};
    int[] y={-1,1,0,0};
    int m;
    int n;
    private void helper(int[] cur,int[][] board){
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{cur[0],cur[1]});
        board[cur[0]][cur[1]]=0;
        while(!q.isEmpty()){
            int [] c=q.poll();
            for(int i=0;i<4;i++){
                int tx=c[0]+x[i];
                int ty=c[1]+y[i];
                if(tx>=0 && tx<m && ty>=0 && ty<n && board[tx][ty]==1){
                    board[tx][ty]=0;
                    q.add(new int[]{tx,ty});
                }
            }
        }
    }
    public int numEnclaves(int[][] board) {
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]==1)
                helper(new int[]{i,0},board);
            if(board[i][n-1]==1)
                helper(new int[]{i,n-1},board);
        }
        for(int i=0;i<n;i++){
            if(board[0][i]==1)
                helper(new int[]{0,i},board);
            if(board[m-1][i]==1)
                helper(new int[]{m-1,i},board);
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1)
                    c++;
            }
        }
        return c;
    }
}