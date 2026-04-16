import heapq
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if len(stones) == 1:
            return stones[0]
        
        heap = []
        for sw in stones:
            heapq.heappush(heap, -sw)

        while len(heap) > 1:
            sw1 = -heapq.heappop(heap)
            sw2 = -heapq.heappop(heap)
            diff = abs(sw1-sw2)
            if diff != 0:
                heapq.heappush(heap, -diff)

        return -heap[0] if len(heap) == 1 else 0