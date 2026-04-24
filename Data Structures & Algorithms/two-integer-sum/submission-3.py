#Clarifiying questions:
# 1. can it contain negatives? ideally it can since it's integers
# 2. We also know that there can duplicates as well from the input
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sum_map = {}
        diff = 0
        for i in range(len(nums)):
            diff = target-nums[i]
            if diff in sum_map:
                return [sum_map[diff],i]
            else:
                sum_map[nums[i]] = i
        return [-1,-1]