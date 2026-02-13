import java.util.*;

public class ReplaceElementsWithRanks{
    public static int[] replaceElementsWithRanks(int[] arr) {
        //Write Your Code Here...
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<arr.length;i++)
            pq.add(new int []{arr[i],i});
        int[] ans=new int[arr.length];
        int last = -1;
        int rank = 0;
        while(!pq.isEmpty())
        {
            int top[] = pq.poll();
            int cur = top[0];
            int ind = top[1];
            
            if(cur!=last){
                rank++;
                last = cur;
            }
            ans[ind] = rank;
  
        } 
        return ans;
        
        
    }
}