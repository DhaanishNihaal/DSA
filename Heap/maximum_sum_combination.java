class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        int n=a.length;
        HashSet<String> vis = new HashSet<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>((x,y)->y[0]-x[0]);
        ArrayList<Integer> list=new ArrayList<>();
        pq.add(new int[]{a[n-1]+b[n-1],n-1,n-1});
        vis.add((n-1)+","+(n-1));
        while(k-->0){
            int[] arr=pq.poll();
            int sum=arr[0];
            int i=arr[1];
            int j=arr[2];
            list.add(sum);
            if(i-1>=0){
                String cur=(i-1)+","+j;
                if(!vis.contains(cur)){
                    pq.add(new int[] {a[i-1]+b[j],i-1,j});
                    vis.add(cur);
                }
            }
            if(j-1>=0){
                String cur=i+","+(j-1);
                if(!vis.contains(cur)){
                    pq.add(new int[] {a[i]+b[j-1],i,j-1});
                    vis.add(cur);
                }
            }
        }
        return list;
        
    }
}