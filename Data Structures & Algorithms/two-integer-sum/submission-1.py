class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_map = {}
        for r in range(len(nums)):
            index_map[nums[r]] = r

        for r in range(len(nums)):
            compliment = target - nums[r]
            if compliment in index_map and r != index_map[compliment]:
                return [r,index_map[(target - nums[r])]]
        return [-1,-1]