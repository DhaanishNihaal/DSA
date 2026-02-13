class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        //Arrays.sort(arr);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<=k;i++){
            pq.add(arr[i]);
        }
        int j=0;
        for(int i=k+1;i<arr.length;i++){
            arr[j++]=pq.poll();
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            arr[j++]=pq.poll();
        }
    }
}
