class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_map = {}
        for r in range(len(nums)):
            compliment = target - nums[r]
            if compliment in index_map:
                return [index_map[(target - nums[r])],r]
            
            index_map[nums[r]] = r 
        return [-1,-1]