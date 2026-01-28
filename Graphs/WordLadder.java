class Solution {
    class Pair{
        String val;
        int level;
        public Pair(String val,int level){
            this.val=val;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        int l=beginWord.length();
        for(String w:wordList){
            char[] word=w.toCharArray();
            for(int i=0;i<l;i++){
                char org=word[i];
                word[i]='*';
                String pat=new String(word);
                map.putIfAbsent(pat,new ArrayList<>());
                map.get(pat).add(w);
                word[i]=org;
            }
        }
        if (!wordList.contains(endWord)) return 0;
        ArrayDeque<Pair> que=new ArrayDeque<>();
        que.add(new Pair(beginWord,1));
        HashSet<String> vis=new HashSet();
        vis.add(beginWord);
        while(!que.isEmpty()){
            Pair cur=que.poll();
            String curVal=cur.val;
            int curLevel=cur.level;
            char[] curArr=curVal.toCharArray();
            for(int i=0;i<l;i++){
                char org=curArr[i];
                curArr[i]='*';
                String curStr=new String(curArr);
                ArrayList<String> curList=map.get(curStr);
                if(curList==null){ 
                    curArr[i]=org;
                    continue;
                }
                for(String word : curList){
                    if(word.equals(endWord)) return curLevel+1;
                    else{
                        if(!vis.contains(word)){
                            vis.add(word);
                            que.add(new Pair(word,curLevel+1));
                        }
                    }
                }
                curArr[i]=org;
            }
        }
        return 0;
    }
}