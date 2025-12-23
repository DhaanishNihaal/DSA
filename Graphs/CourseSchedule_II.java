class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ind=new int[numCourses];
        int c=0;
        ArrayList<Integer> out=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
            ind[edge[0]]++;
        }
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
            if(ind[i]==0)
                q.add(i);
        while(!q.isEmpty()){
            int cur=q.poll();
            out.add(cur);
            c++;
            for(int nei:adj.get(cur)){
                ind[nei]--;
                if(ind[nei]==0)
                    q.add(nei);
            }
        }
        if(c!=numCourses) return new int[] {};
        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = out.get(i);
        }
        return arr;
    }
}