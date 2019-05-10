from collections import defaultdict

class Twitter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.tweets     = []
        self.userTweets = defaultdict(list)
        self.followees  = defaultdict(set)
        

    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: None
        """
        self.tweets.append((userId, tweetId))
        self.userTweets[userId].append((len(self.tweets), tweetId))
        

    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        LIMIT = 10
        userAndFollowees = self.followees[userId]
        userAndFollowees.add(userId)
        allTweets = set()
        for uId in userAndFollowees:
            n = len(self.userTweets[uId])
            minLimit = min(LIMIT, n)
            for i in range(n-1, n-minLimit-1, -1):
                allTweets.add(self.userTweets[uId][i])

        minLimit = min(LIMIT, len(allTweets))
        recentTweets = sorted(allTweets, reverse=True)[:minLimit]
        return [tId for (tPos, tId) in recentTweets]
    

    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: None
        """
        self.followees[followerId].add(followeeId)
        

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: None
        """
        try:
            self.followees[followerId].remove(followeeId)
        except KeyError:
            pass
        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
