class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def houseRobber(cash):
            if len(cash) == 1:
                return cash[0]

            dp = [0] * len(cash)
            dp[0] = cash[0]
            dp[1] = max(dp[0], cash[1])
            for i in range(2,len(cash)):
                dp[i] = max(dp[i-2]+cash[i], dp[i-1])
            return dp[-1]

        if len(nums) == 1:
            return nums[0]
        
        return max(houseRobber(nums[1:]), houseRobber(nums[:-1]))