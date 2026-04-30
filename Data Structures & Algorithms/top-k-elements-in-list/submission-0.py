class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums_count = Counter(nums)
        heap = []

        for num,freq in nums_count.items():
            heapq.heappush(heap,(freq, num))
            while len(heap) > k:
                heapq.heappop(heap)
            
        return [num for freq,num in heap]