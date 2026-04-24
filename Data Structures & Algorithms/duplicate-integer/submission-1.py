class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        res = set()
        for val in nums:
            if val in res:
                return True
            else:
                res.add(val)
        return False