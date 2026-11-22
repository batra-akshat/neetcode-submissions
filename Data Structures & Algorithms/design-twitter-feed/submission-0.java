class Twitter {

    static class Tweet {
        Integer tweetId;
        Integer timestamp;
        Tweet(Integer tweetId, Integer timestamp) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }

    private final HashMap<Integer, LinkedList<Tweet>> userIdToTweetIds;
    private final HashMap<Integer, TreeSet<Integer>> userIdToFollowing;
    Integer timestamp;

    public Twitter() {
        userIdToTweetIds = new HashMap<>();
        userIdToFollowing = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        var existingTweets = userIdToTweetIds.getOrDefault(userId, new LinkedList<>());
        existingTweets.add(new Tweet(tweetId, timestamp));
        userIdToTweetIds.put(userId, existingTweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        var userIds = userIdToFollowing.getOrDefault(userId, new TreeSet<>());
        userIds.add(userId);
        List<Integer> ans = new ArrayList<>();
        
        // Store the current "head" tweet for each user (the next tweet to be considered)
        Map<Integer, Tweet> userToCurrentTweet = new HashMap<>();
        Map<Integer, Iterator<Tweet>> userToIterator = new HashMap<>();
        
        // Initialize iterators and get the first tweet from each user
        for (var user : userIds) {
            var userTweets = userIdToTweetIds.getOrDefault(user, new LinkedList<>());
            if (!userTweets.isEmpty()) {
                Iterator<Tweet> iterator = userTweets.descendingIterator();
                userToIterator.put(user, iterator);
                if (iterator.hasNext()) {
                    userToCurrentTweet.put(user, iterator.next());
                }
            }
        }

        // Get up to 10 most recent tweets
        while (ans.size() < 10 && !userToCurrentTweet.isEmpty()) {
            int latestTweetId = -1;
            int latestTimestamp = -1;
            int userWithLatestTweet = -1;
            
            // Find the user with the most recent tweet among current tweets
            for (var entry : userToCurrentTweet.entrySet()) {
                Tweet tweet = entry.getValue();
                if (tweet.timestamp > latestTimestamp) {
                    latestTweetId = tweet.tweetId;
                    latestTimestamp = tweet.timestamp;
                    userWithLatestTweet = entry.getKey();
                }
            }
            
            // Add the most recent tweet to result
            if (latestTweetId != -1) {
                ans.add(latestTweetId);
                
                // Move to the next tweet for this user
                Iterator<Tweet> iterator = userToIterator.get(userWithLatestTweet);
                if (iterator.hasNext()) {
                    userToCurrentTweet.put(userWithLatestTweet, iterator.next());
                } else {
                    // No more tweets from this user, remove from consideration
                    userToCurrentTweet.remove(userWithLatestTweet);
                    userToIterator.remove(userWithLatestTweet);
                }
            } else {
                break; // No tweets found, exit loop
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) { // Prevent self-following
            var existingFollowing = userIdToFollowing.getOrDefault(followerId, new TreeSet<>());
            existingFollowing.add(followeeId);
            userIdToFollowing.put(followerId, existingFollowing);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        var existingFollowing = userIdToFollowing.getOrDefault(followerId, new TreeSet<>());
        existingFollowing.remove(followeeId);
        userIdToFollowing.put(followerId, existingFollowing);
    }
}
