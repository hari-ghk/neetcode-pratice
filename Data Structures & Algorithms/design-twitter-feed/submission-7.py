class Twitter:
   
    def __init__(self):
        self.users = {}
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId in self.users:
            self.users[userId][0].append((self.time, tweetId))  # ✅ tuple
        else: 
            self.users[userId] = ([(self.time, tweetId)], set())
        self.time += 1

    def getNewsFeed(self, userId: int):
        if userId not in self.users:
            return []

        heap = []

        for time, tweet in self.users[userId][0]:
            heapq.heappush(heap, (time, tweet))
            if len(heap) > 10:
                heapq.heappop(heap)

        for val in self.users[userId][1]:
            if val in self.users:
                for time, tweet in self.users[val][0]:    
                    heapq.heappush(heap, (time, tweet))
                    if len(heap) > 10:
                        heapq.heappop(heap)

        return [tweet for _, tweet in sorted(heap, reverse=True)]            

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId:
            return

        if followerId not in self.users:
            self.users[followerId] = ([], set())

        self.users[followerId][1].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.users:
            self.users[followerId][1].discard(followeeId) 