import java.util.concurrent.atomic.*

class Twitter {
    var tweetOrder: AtomicInteger = AtomicInteger(0)

    data class Tweet(val id: Int,
                     val userId: Int,
                     val createdAt: Int)

    data class Follow(val followerId: Int,
                      val followeeId: Int)

    val tweets = mutableListOf<Tweet>()
    val follows = mutableSetOf<Follow>()

    fun postTweet(userId: Int, tweetId: Int) {
        tweets.add(Tweet(tweetId, userId, tweetOrder.getAndIncrement()))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val myTweets = tweets.filter { it.userId == userId }
        val feeds = mutableListOf<Tweet>()
        feeds.addAll(myTweets)

        val myFollowees = follows.filter { it.followerId == userId }.map { it.followeeId }
        for (myFollowee in myFollowees) {
            val followeesTweets = tweets.filter { it.userId == myFollowee }
            feeds.addAll(followeesTweets)
        }

        feeds.sortByDescending { it.createdAt }
        return feeds.take(10).map { it.id }
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (followerId == followeeId) return
        follows.add(Follow(followerId, followeeId))
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        follows.removeAll { it.followerId == followerId && it.followeeId == followeeId }
    }
}
