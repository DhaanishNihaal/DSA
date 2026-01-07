class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost=0;
        for(int i:arr){
            pq.add(i);
        }
        while(pq.size()>1){
            int a=pq.poll()+pq.poll();
            cost+=a;
            pq.add(a);
        }
        return cost;
    }
}