class Twitter {
    HashMap<Integer,ArrayList<int[]>> tweets;
    HashMap<Integer,HashSet<Integer>> followMap;
    int time;
    public Twitter() {
        tweets=new HashMap<>();
        followMap=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> followList=new ArrayList<>();
        followList.add(userId);
        if(followMap.containsKey(userId)){
            for(int user:followMap.get(userId)){
                followList.add(user);
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int user:followList){
            if(tweets.containsKey(user)){
                for(int[] tweet:tweets.get(user)){
                    pq.add(tweet);
                    if(pq.size()>10) pq.poll();
                }
            }
        }
        ArrayList<Integer> feed=new ArrayList<>();
        while(!pq.isEmpty()){
            feed.add(pq.poll()[1]);
        }
        Collections.reverse(feed);
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */