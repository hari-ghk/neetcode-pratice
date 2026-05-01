class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        nums.sort()
        curr = nums[0]
        streak = 0
        max_streak = 0
        i = 0
        while i < len(nums):
            if curr != nums[i]:
                curr = nums[i]
                streak = 0

            while i < len(nums) and curr == nums[i]:
                i += 1

            curr += 1
            streak += 1
            max_streak = max(max_streak, streak)

        return max_streak