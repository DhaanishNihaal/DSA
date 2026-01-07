class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i:nums)
            mp.put(i,mp.getOrDefault(i,0)+1);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int key:mp.keySet()){
            pq.add(new int[]{mp.get(key),key});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int [] out=new int[k];
        for(int i=0;i<k;i++)
            out[i]=pq.poll()[1];
        return out;
    }
}