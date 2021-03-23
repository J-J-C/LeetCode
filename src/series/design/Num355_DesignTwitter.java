package series.design;

import java.util.*;
import java.util.stream.Collectors;

public class Num355_DesignTwitter {
}

class Twitter {

  Map<Integer, Set<Integer>> followersMap;
  Map<Integer, LinkedList<Tweet>> tweetMap;
  int timeStamp;

  /**
   * Initialize your data structure here.
   */
  public Twitter() {
    followersMap = new HashMap<>();
    tweetMap = new HashMap<>();
    timeStamp = 0;
  }

  /**
   * Compose a new tweet.
   */
  public void postTweet(int userId, int tweetId) {
    addNewUser(userId);

    LinkedList<Tweet> tweetList = tweetMap.get(userId);
    tweetList.addLast(new Tweet(tweetId, timeStamp));
    timeStamp++;
    if (tweetList.size() > 10) {
      tweetList.poll();
    }
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    addNewUser(userId);
    List<Tweet> tweets = new ArrayList<>();
    tweets.addAll(tweetMap.get(userId));
    for (int f : followersMap.get(userId)) {
      tweets.addAll(tweetMap.get(f));
    }
    Collections.sort(tweets, (o1, o2) -> o2.timeStamp - o1.timeStamp);

    if (tweets.size() <= 10) {
      return tweets.stream().map(Tweet::getTweetId).collect(Collectors.toList());
    } else {
      return tweets.subList(0, 10).stream().map(Tweet::getTweetId).collect(Collectors.toList());
    }
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    if (followeeId == followerId) {
      return;
    }
    addNewUser(followerId);
    addNewUser(followeeId);

    followersMap.get(followerId).add(followeeId);
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {

    if (followeeId == followerId) {
      return;
    }
    addNewUser(followerId);
    addNewUser(followeeId);

    followersMap.get(followerId).remove(followeeId);
  }

  private void addNewUser(int userId) {
    if (!tweetMap.containsKey(userId)) {
      followersMap.put(userId, new HashSet<>());
      tweetMap.put(userId, new LinkedList<>());
    }
  }
}

class Tweet {
  int tweetId;
  int timeStamp;

  public Tweet(int tweetId, int timeStamp) {
    this.tweetId = tweetId;
    this.timeStamp = timeStamp;
  }

  public int getTweetId() {
    return tweetId;
  }
}
