class Twitter {

    private Map<Integer, Set<Integer>> followers;  
    private Map<Integer, List<int[]>> tweetMap; 
    private int time; 

    public Twitter() {
        followers = new HashMap(); 
        tweetMap = new HashMap(); 
        time = 0; 
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList()); 
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feeds = new ArrayList(); 
        feeds.addAll(tweetMap.getOrDefault(userId, new ArrayList())); 

        // add tweets from all the followers 
        for(int followeeId : followers.getOrDefault(userId, new HashSet<>())){
            feeds.addAll(tweetMap.getOrDefault(followeeId, new ArrayList()));
        }

        feeds.sort((a, b) -> b[0] - a[0]); 

        List<Integer> res = new ArrayList(); 

        for(int i=0; i<Math.min(10, feeds.size()); i++){
            res.add(feeds.get(i)[1]);
        }

        return res; 
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
        followers.putIfAbsent(followerId, new HashSet()); 
        followers.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
