class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq= new HashMap<>();
        for(char task:tasks)
            freq.put(task,freq.getOrDefault(task,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq.values()){
            pq.add(f);
        }
        int cycle=n+1;
        int time=0;
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int i=0;
            while(i<cycle && !pq.isEmpty()){
                int f=pq.poll();
                f--;
                time++;
                i++;
                if(f>0){
                    temp.add(f);
                }
            }

            if(pq.isEmpty()){
                if(temp.isEmpty()){
                    break;
                }
                time+=(cycle-i);
            }
            for(int k:temp){
                pq.add(k);
            }
        }
        return time;
    }
}