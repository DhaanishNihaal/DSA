class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : tasks) 
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq.values()) 
            pq.add(f);

        int cycle = n + 1;
        int time = 0;

        while (!pq.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            int i = 0;

            while (i < cycle && !pq.isEmpty()) {
                int f = pq.poll();
                f--;
                time++;

                if (f > 0) arr.add(f);
                i++;
            }
            if(pq.isEmpty() && arr.isEmpty())
                break;
            if (pq.isEmpty())
                time += (cycle - i);

            for (int rem : arr)
                pq.add(rem);
        }

        return time;
    }
}