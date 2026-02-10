// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        ArrayDeque<int[]> que=new ArrayDeque<>();
        que.add(new int[]{start,0});
        int[] dist=new int[100000];
        dist[start]=0;
        Arrays.fill(dist,Integer.MAX_VALUE);
        while(!que.isEmpty()){
            int[] cur=que.poll();
            int curVal=cur[0];
            int curLev=cur[1];
            if(curVal==end) return curLev;
            for(int num:arr){
                int val=(curVal*num)%100000;
                if(dist[val]>dist[curVal]+1){
                    que.add(new int[]{val,curLev+1});
                    dist[val]=dist[curVal]+1;
                }
            }
        }
        return -1;
    }
}
