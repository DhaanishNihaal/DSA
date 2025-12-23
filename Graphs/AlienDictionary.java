class Solution {
    public String findOrder(String[] words) {
        // code here
        HashMap<Character,ArrayList<Character>> adj=new HashMap<>();
        HashMap<Character,Integer> ind=new HashMap<>();
        for(String s:words){
            for(char c:s.toCharArray()){
                adj.putIfAbsent(c,new ArrayList<>());
                ind.putIfAbsent(c,0);
            }
        }
        int n=ind.size();
        for(int i=0;i<words.length-1;i++){
            String str1=words[i];
            String str2=words[i+1];
            int len = Math.min(str1.length(),str2.length());
            int f=0;
            for(int j=0;j<len;j++){
                if(str1.charAt(j)!=str2.charAt(j)){
                    f=1;
                    adj.get(str1.charAt(j)).add(str2.charAt(j));
                    ind.put(str2.charAt(j),ind.get(str2.charAt(j))+1);
                    break;
                }
            }
            if(f==0 && str1.length()>str2.length()) return "";
        }
        Deque<Character> q=new ArrayDeque<>();
        for(char c:ind.keySet()){
            if(ind.get(c)==0) q.add(c);
        }
        StringBuilder ans=new StringBuilder();
        while(!q.isEmpty()){
            char cur=q.poll();
            ans.append(cur);
            for(char c:adj.get(cur)){
                ind.put(c,ind.get(c)-1);
                if(ind.get(c)==0) q.add(c);
            }
        }
        if(ans.length()<ind.size()) return "";
        return  ans.toString();
    }
}