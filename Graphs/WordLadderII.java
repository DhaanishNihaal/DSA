class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,ArrayList<String>> parents=new HashMap<>();
        HashMap<String,Integer> dist=new HashMap<>();
        Set<String> list=new HashSet<>(wordList);
        List<List<String>> ans= new ArrayList<>();
        if(!list.contains(endWord)) return ans;
        list.add(beginWord);
        dist.put(beginWord,0);
        bfs(beginWord,endWord,list,parents,dist);
        ArrayList<String> path=new ArrayList<>();
        if (!dist.containsKey(endWord)) return ans;
        dfs(beginWord,endWord,parents,path,ans);
        return ans;
    }
    private void bfs(String beginWord,String endWord,Set<String> list,HashMap<String,ArrayList<String>> parents,HashMap<String,Integer> dist){
        ArrayDeque<String> que=new ArrayDeque<>();
        que.add(beginWord);
        int s=beginWord.length();
        while(!que.isEmpty()){
            int size=que.size();
            for(int k=0;k<size;k++){
                String curStr=que.poll();
                int level=dist.get(curStr);
                char[] curArr=curStr.toCharArray();
                for(int i=0;i<s;i++){
                    char org=curArr[i];
                    for(char j='a';j<='z';j++){
                        if(j==org) continue;
                        curArr[i]=j;
                        String word=new String(curArr);
                        if(!list.contains(word)) continue;

                        if(!dist.containsKey(word)){
                            dist.put(word,level+1);
                            que.add(word);
                            parents.putIfAbsent(word,new ArrayList<>());
                            parents.get(word).add(curStr);
                        }
                        else if(dist.get(word)==level+1){
                            parents.get(word).add(curStr);
                        }

                    }
                    curArr[i]=org;
                }
            }
            if(dist.containsKey(endWord)) break;
        }
    }
    private void dfs(String beginWord,String word,HashMap<String,ArrayList<String>> parents,ArrayList<String> path,List<List<String>> ans){
        path.add(word);
        if(word.equals(beginWord)){
            List<String> temp=new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
        }
        else{
            List<String> parList=parents.get(word);
            if(!(parList==null)){
                for(String par:parList){
                    dfs(beginWord,par,parents,path,ans);
                }
            }
        }
        path.remove(path.size()-1);
    }
}