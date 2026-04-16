import heapq
class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.nums = nums

    def add(self, val: int) -> int:
        self.nums.append(val)
        heap = []
        for val in self.nums:
            heapq.heappush(heap, val)
            if len(heap) > self.k:
                heapq.heappop(heap)

        return heap[0]